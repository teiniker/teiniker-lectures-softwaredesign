package org.se.lab.example5;


/**
 * Enforce the singleton property with an enum type.
 *
 * see Effective Java, Second Edition - Item 3
 */
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
