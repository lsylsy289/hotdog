package hotdog.board.ctrl;

import hotdog.board.svc.BoardService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	private Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView getBoardListPage() {

		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/boardList.tiles");
		mv.addObject("boardList", boardService.selectBoardList());
		
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
	public ModelAndView getBoardEditPage() {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("board/boardEdit.tiles");
		
		return mv;
	}
	
	@RequestMapping(value = "/board/boardSave.do", method = RequestMethod.POST)
	public ModelAndView saveBoard(BoardVO boardVO, HttpSession hs) {
		
		ModelAndView mv = new ModelAndView();
		
		boardVO.setRgstUserId(hs.getAttribute("userId").toString());
		
		boardService.saveBoard(boardVO);
		
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
