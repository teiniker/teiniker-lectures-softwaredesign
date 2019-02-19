package org.se.lab;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Adapter
 * 
 * This class adapts the interface of Adaptee to the target interface.
 * (Here we use an object adapter)
 */
class CustomLoggerAdapter // package private
    implements CustomLogger
{
    /*
     * Adaptee
     * 
     * This is a reference to a class that needs adapting.
     */
    private Logger logger; // ---[1]-> Logger

    
    /* 
     * Constructor
     */
    public CustomLoggerAdapter(String name, Level level)
    {
    	logger = Logger.getLogger(name);
    	
        // turn off the default logger handler
        LogManager.getLogManager().reset();
        Logger globalLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        globalLogger.setLevel(java.util.logging.Level.OFF);
    
        // add custom console handler
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(new CustomFormatter());
        logger.addHandler(ch);
        logger.setLevel(level);        
    }
    
    
    /* 
     * Adapter Methods 
     */
    
    public void error(String message)
    {
        logger.severe("ERROR  : " + message);
    }

    
    public void warning(String message)
    {
        logger.warning("WARNING: " + message);
    }
    

    public void info(String message)
    {
        logger.info("INFO   : " + message);
    }

    
    public void debug(String message)
    {
        logger.finer("DEBUG  : " + message);
    }    
}
