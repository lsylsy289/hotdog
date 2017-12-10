package hotdog.commons.login;

import java.util.Properties;

import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired private JavaMailSenderImpl mailSender;

	@Autowired private Properties common;

	@Value("#{common['mail.from']}") // 메일 송신계정
	private String mailFrom;
	@Value("#{common['mail.to']}") // 메일 수신계정
	private String mailTo;

	public String getPropertyValue(String key) {
		return common.getProperty(key);
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public ModelAndView getLoginPage(@RequestParam(required=false) String fail, @RequestParam(required=false) String logout) {

		ModelAndView mv = new ModelAndView();

		if ( null != fail ) {

			mv.addObject("fail", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}

		if ( null != logout ) {

			mv.addObject("msg", "로그아웃을 성공하였습니다.");
		}

		mv.setViewName("login/login.tiles");

		return mv;
	}

	/**
	 * @description w3c의 dom방식 xml pasing
	 * @param request
	 * @return String xml
	 */
	@RequestMapping(value = "/xmlpasingTest.do")
	public @ResponseBody String apiXmlpasing(HttpServletRequest request) {

		StringBuilder sbd = new StringBuilder();

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(request.getInputStream());
			doc.getDocumentElement().normalize();

			logger.info(doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("staff");

			sbd.append("<?xml version=\"1.0\"?>");
			sbd.append("<company>");

			for (int intIndex = 0; intIndex < nList.getLength(); intIndex++) {

				Node nNode = nList.item(intIndex);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					logger.info(getNodeValue(eElement, "firstname"));
					logger.info(getNodeValue(eElement, "lastname"));
					logger.info(getNodeValue(eElement, "nickname"));
					logger.info(getNodeValue(eElement, "salary"));

					sbd.append("<staff>");
					sbd.append("<firstname>" + getNodeValue(eElement, "firstname") + "</firstname>");
					sbd.append("<lastname>" + getNodeValue(eElement, "lastname") + "</lastname>");
					sbd.append("<nickname>" + getNodeValue(eElement, "nickname") + "</nickname>");
					sbd.append("<salary>" + getNodeValue(eElement, "salary") + "</salary>");
					sbd.append("</staff>");
				}
			}

			sbd.append("</company>");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return sbd.toString();
	}

	/**
	 * @description Xml에 노드를 읽어 String으로 리턴한다.
	 * @param element
	 * @param tagName
	 * @return String
	 */
	public String getNodeValue(Element element, String tagName) {
		return element.getElementsByTagName(tagName).item(0).getChildNodes().item(0).getNodeValue();
	}

	@RequestMapping(value = "/sendEmail.do")
	public void sendMail(final HttpServletRequest request) {

		final MimeMessagePreparator preparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				final MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

				helper.setFrom(getPropertyValue("mail.from"));
				helper.setTo(getPropertyValue("mail.to"));
				helper.setSubject("테스트입니다!!");

				String image = "http://" + request.getServerName() + ":" + request.getServerPort() + getPropertyValue("mail.image");
				String content = "여러분 너무 좋은 날이에요~" + "<img src=" + image + " />";

				helper.setText(content, true);

				FileSystemResource file = new FileSystemResource("C:\\test.txt");
				FileSystemResource file2 = new FileSystemResource("C:\\Setup.log");
				helper.addAttachment("test.txt", file);
				helper.addAttachment("Setup.txt", file2);
			}
		};

		mailSender.send(preparator);
	}
}