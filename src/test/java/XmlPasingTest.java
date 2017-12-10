import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @descriptions XML 형식의 데이터를 받고 XML 형식으로 리턴한다.
 * @author lsylsy289
 * @since 2017.12.09
 */

@Component
@Lazy
public class XmlPasingTest {

	private static Logger logger = LoggerFactory.getLogger(XmlPasingTest.class);

	@Test
	public void fileXmlpasing() {

		try {

			File xmlFile = new File("C:\\file.xml");

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();

			logger.info(doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("staff");

			for (int intIndex = 0; intIndex < nList.getLength(); intIndex++) {

				Node nNode = nList.item(intIndex);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					logger.info(eElement.getElementsByTagName("firstname").item(0).getChildNodes().item(0).getNodeValue());
					logger.info(eElement.getElementsByTagName("lastname").item(0).getChildNodes().item(0).getNodeValue());
					logger.info(eElement.getElementsByTagName("nickname").item(0).getChildNodes().item(0).getNodeValue());
					logger.info(eElement.getElementsByTagName("salary").item(0).getChildNodes().item(0).getNodeValue());
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
}
