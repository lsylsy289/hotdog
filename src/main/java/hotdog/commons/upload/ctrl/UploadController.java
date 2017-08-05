package hotdog.commons.upload.ctrl;

import hotdog.commons.Base;
import hotdog.commons.JsonUtil;
import hotdog.commons.UploadUtil;
import hotdog.commons.upload.svc.UploadService;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class UploadController {

//    @Autowired private EgovPropertyService propertiesService;
	
    @Resource(name = "uploadService")
    private UploadService uploadservice;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = {"/jqueryUpload.do", "/dropzoneUpload.do"})
    public String uploadInit(HttpServletRequest request) throws Exception {

        return "upload" + request.getRequestURI().replace(".do", "") + ".tiles";
    }

    @RequestMapping(value="/upload/saveUpload.do", method = RequestMethod.POST)
    public @ResponseBody String saveUpload(MultipartHttpServletRequest request, HttpServletResponse response) throws Exception {

        MultipartFile mutipartFile = request.getFile(request.getFileNames().next());

        String filePath = "C:/files/";

        String originalFileName = mutipartFile.getOriginalFilename();

        String fileId = Base.getId();
        
        String storedFileName = fileId + "_" + originalFileName;

        mutipartFile.transferTo(new File(filePath + storedFileName));

        Map<String, Object> paramMap = new HashMap<String, Object>();

        paramMap.put("fileId", fileId);
        paramMap.put("originalFileName", originalFileName);
        paramMap.put("storedFileName", storedFileName);
        paramMap.put("filePath", filePath + storedFileName);
        paramMap.put("fileSize", mutipartFile.getSize());

        uploadservice.uploadSave(paramMap);
        
        return fileId;
    }

    @RequestMapping(value="/upload/onloadUpload.do", method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> onloadUpload(@RequestParam String fileId) throws Exception {

    	Map<String, Object> paramMap = new HashMap<String, Object>();
    	
    	paramMap.put("fileId", fileId);
    	
    	Map<String, Object> resultMap = new HashMap<String, Object>();
    	
    	resultMap.put("row", uploadservice.selectUploadList(paramMap));
    	
        return resultMap;
    }

    @RequestMapping(value = "/upload/fileDownload.do", method = RequestMethod.POST)
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {

        UploadUtil uploadUtil = new UploadUtil();

        String originalFileName = request.getParameter("originalFileName");
        String fFileName = request.getParameter("fFileName");

        String filePath = "C:/files/";

        String fullPath = filePath + fFileName;

        File file = new File(fullPath);

        response.setContentType(uploadUtil.getContentType(FilenameUtils.getExtension(originalFileName)));

        uploadUtil.setDisposition(originalFileName, request, response);

        response.setHeader("Content-Trasfer-Encoding", "binary;");
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1");

        response.setContentLength((int)file.length());

        FileCopyUtils.copy(new FileInputStream(file), response.getOutputStream());
    }

    @RequestMapping(value = "uploadDelteTest.do", method = RequestMethod.POST)
    public void deleteTest(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String filePath = "C:/files/";
        String storedFileName = request.getParameter("storedFileName");

        Map<String, Object> paramMap = new HashMap<String, Object>();
        
        paramMap.put("seqNo", request.getParameter("seqNo"));
        
        try {
        	uploadservice.deleteUpload(paramMap);
			
			File file = new File(filePath + storedFileName);
			
			if (file.exists()) {
				
				file.delete();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}