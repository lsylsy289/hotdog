package hotdog.jqgrid.service;

import java.util.List;

import org.json.JSONArray;

import hotdog.jqgrid.controller.JqgridVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface JqgridService {

	List<EgovMap> selectJqgridList(JqgridVO jqgridVO);

	EgovMap selectJqgridCnt(JqgridVO jqgridVO);

	void JqgridTx(JSONArray jsonArray);
}
