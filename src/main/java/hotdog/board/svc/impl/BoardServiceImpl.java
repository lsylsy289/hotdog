package hotdog.board.svc.impl;

import hotdog.board.ctrl.BoardVO;
import hotdog.board.dao.BoardDao;
import hotdog.board.svc.BoardService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name = "boardDao")
	private BoardDao boardDao;
	
	@Override
	public List<Map<String, Object>> selectBoardList() {
		
		return boardDao.selectBoardList();
	}

	@Override
	public Map<String, Object> selectBoardDetail(String boardSeq) {
		
		return boardDao.selectBoardDetail(boardSeq);
	}
	
	@Override
	public int saveBoard(BoardVO boardVO) {
		
		return boardDao.saveBoard(boardVO);
	}

	@Override
	public void updateViewCnt(String boardSeq) {
		
		boardDao.updateViewCnt(boardSeq);
	}

	@Override
	public void deleteBoard(String boardSeq) {
		
		boardDao.deleteBoard(boardSeq);
	}
}
