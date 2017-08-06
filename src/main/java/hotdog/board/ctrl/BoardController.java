package hotdog.board.ctrl;

import hotdog.board.svc.BoardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView getBoardListPage(@RequestParam(required=false) String pageNo) {

		ModelAndView mv = new ModelAndView();
		
		Map<String,Object> commandMap = new HashMap<String, Object>();
	    
		int currentPageNo = StringUtils.isEmpty(pageNo) ? 1 : Integer.parseInt(pageNo);
		
		//PaginationInfo에 필수 정보를 넣어 준다.
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(currentPageNo); //현재 페이지 번호
		paginationInfo.setRecordCountPerPage(5); //한 페이지에 게시되는 게시물 건수
		paginationInfo.setPageSize(10); //페이징 리스트의 사이즈
 
		int firstRecordIndex = paginationInfo.getFirstRecordIndex();
		int lastRecordIndex = paginationInfo.getLastRecordIndex();
		
		commandMap.put("firstIndex", firstRecordIndex + 1 );
		commandMap.put("lastIndex", lastRecordIndex );
 
		List<Map<String, Object>> list = boardService.selectBoardList(commandMap);
		
		paginationInfo.setTotalRecordCount(boardService.selectTotalCount()); //전체 게시물 건 수
 
		//페이징 관련 정보가 있는 PaginationInfo 객체를 모델에 반드시 넣어준다.
		mv.addObject("paginationInfo", paginationInfo);
	    mv.addObject("boardList", list);
		mv.setViewName("board/boardList.tiles");
		
		return mv;
	}
	
	@RequestMapping(value = "/board/boardDetail.do")
	public ModelAndView getBoardDetailPage(@RequestParam String boardSeq) {
		
		ModelAndView mv = new ModelAndView();
		
		boardService.updateViewCnt(boardSeq);
		
		mv.setViewName("board/boardDetail.tiles");
		mv.addObject("board", boardService.selectBoardDetail(boardSeq));
		
		return mv;
	}
	
	@RequestMapping(value = "/board/boardEdit.do")
	public ModelAndView getBoardEditPage(@RequestParam(required = false) String updtYn, @RequestParam(required = false) String boardSeq) {
		
		ModelAndView mv = new ModelAndView();
		
		if ( !updtYn.isEmpty() && updtYn.equals("true") ) 
			mv.addObject("board", boardService.selectBoardDetail(boardSeq));
		
		mv.setViewName("board/boardEdit.tiles");
		
		return mv;
	}
	
	@RequestMapping(value = "/board/boardSave.do", method = RequestMethod.POST)
	public ModelAndView saveBoard(BoardVO boardVO, HttpSession hs) {
		
		ModelAndView mv = new ModelAndView();
		
		String userId = hs.getAttribute("userId").toString();
		
		boardVO.setRgstUserId(!userId.isEmpty() ? userId : "ADMIN");
		
		int resultRow = boardService.saveBoard(boardVO);
		
		mv.addObject("resultCode", resultRow > 0 ? "SUCCESS" : "FAIL");

		mv.setViewName("board/boardEdit.tiles");
		
		return mv;
	}
	
	@RequestMapping(value = "/board/deleteBoard.do")
	public ModelAndView deleteBoard(@RequestParam String boardSeq) {
		
		ModelAndView mv = new ModelAndView();
		
		boardService.deleteBoard(boardSeq);
		
		mv.setViewName("board/boardDetail.tiles");
		
		return mv;
	}
}
