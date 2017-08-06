package hotdog.board.dao;

import hotdog.board.ctrl.BoardVO;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("boardDao")
public interface BoardDao {

	List<Map<String, Object>> selectBoardList(Map<String, Object> commandMap);

	Map<String, Object> selectBoardDetail(String boardSeq);
	
	int insertBoard(BoardVO boardVO);
	
	int updateBoard(BoardVO boardVO);

	void updateViewCnt(String boardSeq);

	void deleteBoard(String boardSeq);

	int selectTotalCount();

}
