package test.quinFS;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LogTest {

	@Test
	public void testLog() {
		Logger logger = Logger.getLogger(LogTest.class);
		logger.info("hello");
	}
}
