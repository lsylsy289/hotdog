import java.util.StringTokenizer;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringTokenizerTest {

	private static Logger logger = LoggerFactory.getLogger(StringTokenizerTest.class);

	@Test
	public void stringTokenizer() {

		String alpabets = "A, B, C, D, E, F";

		StringTokenizer stkz = new StringTokenizer(alpabets, ", ");

		while (stkz.hasMoreElements()) {

			logger.info(stkz.nextElement().toString());
		}
	}
}
