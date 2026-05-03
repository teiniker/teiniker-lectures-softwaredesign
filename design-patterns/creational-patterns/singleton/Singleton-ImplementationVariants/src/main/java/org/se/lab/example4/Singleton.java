package org.se.lab.example4;

public enum Singleton
{
    INSTANCE;  // Ensure a unique instance
    
    /*
     * Operations
     */
    
    public String getVersionNumber()
    {
        return "1.0.0";
    }
}
