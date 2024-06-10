package org.se.lab;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;


public class Log4jTest
{
	/*
	 * The default configuration file is called log4j.properties
	 * and can be found on the CLASSPATH
	 */
	@Test
	public void testLoggerWithDefaultConfiguratonFile()
	{
		final Logger LOG = LogManager.getLogger(Log4jTest.class);
		callLoggerMethods(LOG);
	}


	// Log levels: trace > debug > info > warning > error > fatal
	protected void callLoggerMethods(Logger logger)
	{
		logger.trace("trace");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");
		logger.fatal("fatal");		
		logger.debug("debug with exception", new IllegalArgumentException());				
	}
}
