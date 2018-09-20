package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTest
{
	@Test
	public void testSingleObject()
	{
		Logger log1 = Logger.getInstance();
		Logger log2 = Logger.getInstance();
		Assert.assertTrue(log1 == log2);
		
	}
	

	@Test
	public void testDebug()
	{
		Logger log = Logger.getInstance();
		log.debug("This is a debug message");
		
	}

	@Test
	public void testInfo()
	{
		Logger log = Logger.getInstance();
		log.info("This is an information");	
	}

}
