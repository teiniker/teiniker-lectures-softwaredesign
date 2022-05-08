package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Logger
{    
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
