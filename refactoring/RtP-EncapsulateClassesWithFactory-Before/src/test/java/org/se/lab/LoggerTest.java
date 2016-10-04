package org.se.lab;

import org.junit.Test;
import org.se.lab.Logger;
import org.se.lab.TextLogger;
import org.se.lab.XmlLogger;


public class LoggerTest
{
	@Test
	public void testTextLogger()
	{
		Logger log = new TextLogger();
		log.logDebug("Debug Message");	
	}
	
	@Test
	public void testXmlLogger()
	{
		Logger log = new XmlLogger();
		log.logDebug("Debug Message");		
	}
}
