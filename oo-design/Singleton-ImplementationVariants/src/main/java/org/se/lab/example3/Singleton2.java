package org.se.lab.example3;

import static java.lang.System.out;

public class Singleton2
    extends Singleton
{    
    public Singleton2()
    {
        out.println("Singleton2()");
    }
    
    
    /*
     * Operations
     */
     
    public String getVersionNumber()
    {
        final String VERSION = "2.0.0";
        out.println("getVersion()");
        return VERSION;
    }
    
}
