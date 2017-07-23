package hotdog.jqgrid.controller;

import hotdog.commons.JsonUtil;
import hotdog.jqgrid.service.JqgridService;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class JqgridController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "jqgridService")
	private JqgridService JqgridService;
	
	
	@RequestMapping(value = {"jqgridStart.do", "jqgridIUD.do", "jqgridReport.do"})
	public String jqgridStart(HttpServletRequest request) throws Exception {

		return "jqgrid/" + request.getRequestURI().replaceAll(".do", "");
	}
	
	@RequestMapping(value = "jqgridStartMain.do")
	public void jqgridStartMain(HttpServletRequest request, HttpServletResponse response, @ModelAttribute JqgridVO jqgridVO, ModelMap model) throws Exception {
		
		PrintWriter out = null;
		
		response.setCharacterEncoding("UTF-8");
		
		String quotZero = request.getParameter("param");
		
		quotZero = quotZero.replaceAll("&quot;", "\"");
		
		Map<String, Object> castMap = new HashMap<String, Object>();
		
		castMap = JsonUtil.JsonToMap(quotZero);
		
		jqgridVO.setServiceImplYn((String) castMap.get("serviceImplYn"));
		
		List<EgovMap> jqGridList = JqgridService.selectJqgridList(jqgridVO);
		
		EgovMap jqGridListCnt = JqgridService.selectJqgridCnt(jqgridVO);
		
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("records", jqGridListCnt.get("totaltotcnt"));
		resMap.put("rows", jqGridList);
		resMap.put("page", request.getParameter("page"));
		resMap.put("total", jqGridListCnt.get("totalpage"));
		
		out = response.getWriter();
		
		out.write(JsonUtil.HashMapToJson(resMap).toString());
	}
	
	@RequestMapping(value = {"/saveJqgrid.do", "/deleteJqgrid.do"} )
	public @ResponseBody String Jqgrid(@RequestParam String param1) throws Exception {
		
		String result = "";
		
		try {
			
			JqgridService.JqgridTx(new JSONArray(param1.replaceAll("&quot;", "\"")));
			
			result = "SUCCESS";
			
		} catch (Exception e) {
			
			result = "FAIL";
		}
		
		return result;
	}
}
