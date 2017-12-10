import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IteratorTest {

	private static Logger logger = LoggerFactory.getLogger(IteratorTest.class);

	@Test
	public void iteratorList() {

		List<String> sList = new ArrayList<String>();

		sList.add("A");
		sList.add("B");
		sList.add("C");
		sList.add("D");
		sList.add("E");

		Iterator<String> iterator = sList.iterator();

		while (iterator.hasNext()) {

			logger.info(iterator.next());
		}
	}

	@Test
	public void iteratorMap() {

		Map<String, Object> sMap = new HashMap<String, Object>();

		sMap.put("A", "A");
		sMap.put("B", "B");
		sMap.put("C", "C");
		sMap.put("D", "D");
		sMap.put("E", "E");

		Iterator<String> iterator = sMap.keySet().iterator();

		while (iterator.hasNext()) {

			logger.info(iterator.next());
		}
	}
}
