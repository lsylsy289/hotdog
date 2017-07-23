package hotdog.jqgrid.service.impl;

import java.util.List;
import java.util.Map;

import hotdog.jqgrid.controller.JqgridVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Mapper("jqgridMapper")
public interface JqgridMapper {

	List<EgovMap> selectJqgridList(JqgridVO jqgridVO);

	EgovMap selectJqgridCnt(JqgridVO jqgridVO);

	void insertJqgridList(Map<String, Object> param);

	void updateJqgridList(Map<String, Object> param);

	void deleteJqgridList(Map<String, Object> param);
}