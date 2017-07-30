package hotdog.board.svc;

import hotdog.board.ctrl.BoardVO;

import java.util.List;
import java.util.Map;

public interface BoardService {

	List<Map<String, Object>> selectBoardList();

	Map<String, Object> selectBoardDetail(String boardSeq);

	int saveBoard(BoardVO boardVO);

	void updateViewCnt(String boardSeq);

	void deleteBoard(String boardSeq);
}
