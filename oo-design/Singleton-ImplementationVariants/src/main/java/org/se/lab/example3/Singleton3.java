package org.se.lab.example3;

import static java.lang.System.out;

public class Singleton3
    extends Singleton
{    
    public Singleton3()
    {
        out.println("Singleton3()");
    }
    
    
    /*
     * Operations
     */
     
    public String getVersionNumber()
    {
        final String VERSION = "3.0.0";
        out.println("getVersion()");
        return VERSION;
    }
    
}
