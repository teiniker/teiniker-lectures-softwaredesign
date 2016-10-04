package org.se.lab.example2;

import static java.lang.System.out;

public class SingletonSubclass
    extends Singleton
{    
    /*
     * Operations
     */
     
    protected SingletonSubclass()
    {
        super();
    }
    
    public String getVersionNumber()
    {
        final String VERSION = "2.0.0";
        out.println("getVersion()");
        return VERSION;
    }
    
}
