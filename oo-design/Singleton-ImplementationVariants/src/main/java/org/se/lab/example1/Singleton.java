package org.se.lab.example1;

import static java.lang.System.out;

public class Singleton
{
    /*
     * Singleton pattern
     */
    
    private static Singleton instance;    
    
    private Singleton()
    {
        out.println("Singleton()");
    }
    
    public static Singleton getInstance()
    {
        out.println("getInstance()");
        if(instance == null)
        {
            instance = new Singleton();
        }
        return instance;
    }
     
    
    /*
     * Operations
     */
     
    public String getVersionNumber()
    {
        return "1.1.7";
    }
}
