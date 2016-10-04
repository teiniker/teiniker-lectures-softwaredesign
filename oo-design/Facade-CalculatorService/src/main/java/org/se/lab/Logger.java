package org.se.lab;

class Logger // package private
{
    public static final int LOG_ERROR = 1;
    public static final int LOG_WARNING = 2;
    public static final int LOG_INFO = 3;
    public static final int LOG_DEBUG = 4;
    
    
    public void log(final int logLevel, final String s)
    {
        switch(logLevel)
        {
            case LOG_ERROR: System.out.println("[ERROR] " + s); break;
            case LOG_WARNING: System.out.println("[WARNING] " + s); break;
            case LOG_INFO: System.out.println("[INFO] " + s); break;
            case LOG_DEBUG: System.out.println("[DEBUG] " + s); break;
        }
            
    }
}
