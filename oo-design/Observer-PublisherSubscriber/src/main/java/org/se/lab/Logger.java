package org.se.lab;

import java.util.ArrayList;
import java.util.List;

/*
 * This class is used for testing.
 */

public class Logger
{
    private Logger() {}
    private final static Logger INSTANCE = new Logger();
    public static Logger getInstance()
    {
        return INSTANCE;
    }
    
    private List<String> logLines = new ArrayList<String>();
    
    public void log(String msg)
    {
        logLines.add(msg + "\n");
    }
    
    public List<String> getLogLines()
    {
        return logLines;
    }
}
