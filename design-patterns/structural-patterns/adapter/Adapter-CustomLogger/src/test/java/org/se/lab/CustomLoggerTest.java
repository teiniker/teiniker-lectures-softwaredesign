package org.se.lab;

import java.util.logging.Level;

import org.junit.Before;
import org.junit.Test;

public class CustomLoggerTest
{
	private CustomLogger logger;
	
	@Before
	public void setup()
	{
		logger = new CustomLoggerAdapter("org.se.lab", Level.ALL);
	}
	
	
    @Test
    public void testCustomLogger()
    {
        logger.error("This is an error message");
        logger.warning("This is a warning message");
        logger.info("This is an info message");
        logger.debug("This is a debug message");
    }
}
