package org.se.lab.example2;

import static java.lang.System.out;

public class Singleton
{
    /*
     * Singleton pattern
     */
    
    private static Singleton instance;
    
    protected Singleton()
    {
        out.println("Singleton()");
    }
     
    public static Singleton getInstance()
    {
        out.println("getInstance()");
        if(instance == null)
        {
        	// create an instance of a subclass
            instance = new SingletonSubclass();
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
