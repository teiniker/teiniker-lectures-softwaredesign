package org.se.lab;

import org.junit.Test;
import org.se.lab.Logger;


public class LoggerTest
{
	@Test
	public void testTextLogger()
	{
//		Logger2 log = new TextLogger2();	// Class not visible
		Logger log = Logger.createTextLogger();
		log.logDebug("Debug Message");
		
	}

	@Test
	public void testXmlLogger()
	{
//		Logger2 log = new XmlLogger2();		// Class not visible
		Logger log = Logger.createXmlLogger();
		log.logDebug("Debug Message");
	}	
}
