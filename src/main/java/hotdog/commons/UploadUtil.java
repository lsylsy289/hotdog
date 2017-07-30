package hotdog.commons;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadUtil {
	
	/**
	 * 파일 확장자별 컨텐츠 타입을 구한다.
	 * @param extention
	 * @return
	 */
	public String getContentType(String extention) {
		
		String contentFileType = null;
		
		if(extention == null || extention.equals("")) {
			
			contentFileType = "applicationxxxxxxxxxx";
		} else if ((extention).equals("bmp")) {
			
			contentFileType = "image/bmp";
		} else if ((extention).equals("doc")) {
			
			contentFileType = "application/msword";
		} else if ((extention).equals("html")) {
			
			contentFileType = "text/html";
		} else if ((extention).equals("hwp")) {
			
			contentFileType = "application";
		} else if ((extention).equals("jpg")) {
			
			contentFileType = "image/jpeg";
		} else if ((extention).equals("mid")) {
			
			contentFileType = "audio/midi";
		} else if ((extention).equals("mp3")) {
			
			contentFileType = "audio/x-mp3";
		} else if ((extention).equals("mpeg")) {
			
			contentFileType = "video/mpeg";
		} else if ((extention).equals("pdf")) {
			
			contentFileType = "application/pdf";
		} else if ((extention).equals("ppt")) {
			
			contentFileType = "application/vnd.ms-powerpoint";
		} else if ((extention).equals("pptx")) {
			
			contentFileType = "application/vnd.ms-powerpoint";
		} else if ((extention).equals("ra")) {
			
			contentFileType = "audio/x-pn-realaudio";
		} else if ((extention).equals("txt")) {
			
			contentFileType = "text/plain";
		} else if ((extention).equals("xls")) {
			
			contentFileType = "application/vnd.ms-excel";
		} else {
			
			contentFileType = "applicationxxxxxxxxxx";
		}
		
		return contentFileType;
	}
	
	/**
	 * 한글깨짐 방지
	 * @param filename
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void setDisposition(String filename, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		// 브라우저 구분 얻기
		String browser = getBrowser(request);

		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;

		// ie 11
		if (browser.equals("Trident")) {
			
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("MSIE")) {
			
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll(	"\\+", "%20");
		} else if (browser.equals("Firefox")) {

		} else if (browser.equals("Opera")) {
			
			encodedFilename = "\""	+ new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < filename.length(); i++) {
				
				char c = filename.charAt(i);
				
				if (c > '~') {
					
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					
					sb.append(c);
				}
			}
			
			encodedFilename = sb.toString();
		} else {

			throw new IOException("Not supported browser");
		}

		if(browser.equals("Firefox") || browser.equals("Opera")) {
			
			response.setHeader("Content-Disposition", dispositionPrefix + "\"" +filename+ "\"");
		} else {
			
			response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);
		}
	}
	
	/**
	 * 브라우저 구분 얻기
	 * @param 	request
	 * @return 	getBrowser
	 */
	private String getBrowser(HttpServletRequest request) {
		
		String header = request.getHeader("User-Agent");
		
		if ( header.indexOf("Trident") > -1 ) { // ie 11 에서 MSIE가 삭제됨
			
			return "Trident";
		} else if (header.indexOf("MSIE") > -1) {
			
			return "MSIE";
		} else if (header.indexOf("Chrome") > -1) {
			
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			
			return "Opera";
		}
		
		return "Firefox";
	}
}
