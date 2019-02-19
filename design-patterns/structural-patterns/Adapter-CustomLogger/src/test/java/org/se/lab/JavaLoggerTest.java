package org.se.lab;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

import org.junit.Before;
import org.junit.Test;

public class JavaLoggerTest
{
    protected static Logger logger;
    
    @Before
    public void setUp() throws SecurityException, IOException
    {
        logger = Logger.getLogger("org.se.lab");
        
        ConsoleHandler ch = new ConsoleHandler();
        ch.setFormatter(new SimpleFormatter());
        ch.setLevel(Level.ALL);
        logger.addHandler(ch);
        
        FileHandler fh = new FileHandler("logfile.xml");
        fh.setFormatter(new XMLFormatter());
        fh.setLevel(Level.ALL);
        logger.addHandler(fh);        
        logger.setLevel(Level.ALL);        
    }
    
    
    @Test
    public void testJavaLogger() 
    {
        logger.severe("severe message");
        logger.warning("warning message");
        logger.info("info message");
        logger.config("config message");
        logger.fine("fine message");
        logger.finer("finer message");
        logger.finest("finest message");
    }
}
