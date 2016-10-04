package org.se.lab.example3;

import static java.lang.System.out;

import java.util.HashMap;
import java.util.Map;

public class Singleton
{
    /*
     * Singleton pattern
     */
    private static Map<String, Singleton> registry = 
    			new HashMap<String, Singleton>();
    private static Singleton instance;

    static 
    { 
        register("Default", new Singleton());
    }
    
    
    protected Singleton()
    {
        out.println("Singleton()");
    }
         
    public static void register(String name, Singleton s)
    {
        out.println("register(\"" + name + "\", " + s + ")");
        registry.put(name, s);
    }
    
    protected static Singleton lookup(String name)
    {
        out.println("lookup(\"" + name + "\")");
        if(registry.containsKey(name))
        {
            return registry.get(name);
        }
        else
        {
            return registry.get("Default");
        }
    }
    
    public static void reset()
    {
        out.println("reset()");
        instance = null;
    }
    
    
    public static Singleton getInstance()
    {
        out.println("getInstance()");        
        if(instance == null)
        {
            instance = lookup(System.getProperty("Singleton")); 
        }
        return instance;
    }
    
    
    /*
     * Operations
     */
    
    public String getVersionNumber()
    {
        out.println("getVersionNumber()");
        return "1.0.0";
    }
}
