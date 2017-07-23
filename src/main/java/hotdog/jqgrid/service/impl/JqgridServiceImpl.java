package hotdog.jqgrid.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import hotdog.commons.JsonUtil;
import hotdog.jqgrid.service.JqgridService;
import hotdog.jqgrid.controller.JqgridVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Service("jqgridService")
public class JqgridServiceImpl implements JqgridService{

    @Resource(name = "jqgridMapper")
    private JqgridMapper jqgridMapper;

	@Override
	public List<EgovMap> selectJqgridList(JqgridVO jqgridVO) {
		
		return jqgridMapper.selectJqgridList(jqgridVO);
	}

	@Override
	public EgovMap selectJqgridCnt(JqgridVO jqgridVO) {
		// TODO Auto-generated method stub
		return jqgridMapper.selectJqgridCnt(jqgridVO);
	}

	@Override
	public void JqgridTx(JSONArray jsonArray) {

		try {
			
			for (int i = 0; i < jsonArray.length(); i++) {
				
				Map<String, Object> param = JsonUtil.JsonToMap(jsonArray.getJSONObject(i).toString());
				
				if ("I".equals(param.get("editType"))) {
					jqgridMapper.insertJqgridList(param);
				} else if ("U".equals(param.get("editType"))) {
					jqgridMapper.updateJqgridList(param);
				} else if ("D".equals(param.get("editType"))) {
					jqgridMapper.deleteJqgridList(param);
				}
			}
		} catch (Exception e) {
		}
	}
}
