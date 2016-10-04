package org.se.lab.example4;

import static java.lang.System.out;

public class Singleton
{    
    /*
     * The private constructor is called only once, to initialize the static final
     * field INSTANCE.
     */

    private static final Singleton INSTANCE = new Singleton();
    private Singleton()
    {
        out.println("Singleton()");
    }
    public static Singleton getInstance()
    {
        out.println("getInstance()");
        return INSTANCE;
    }
     
    
    /*
     * Operations
     */
     
    public String getVersionNumber()
    {
        final String VERSION = "1.1.7";
        out.println("getVersion()");
        return VERSION;
    }
    
}