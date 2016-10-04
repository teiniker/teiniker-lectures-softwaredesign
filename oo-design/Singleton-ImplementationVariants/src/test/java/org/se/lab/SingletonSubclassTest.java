package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.se.lab.example2.Singleton;
import org.se.lab.example2.SingletonSubclass;


public class SingletonSubclassTest
{
    @Test
    public void testSingletonType()
    {
        Singleton singleton = Singleton.getInstance();
        assertTrue(singleton instanceof Singleton);
        assertTrue(singleton instanceof SingletonSubclass);
    }
    
    @Test
    public void testSoleInstance()
    {
        Singleton firstSingleton = Singleton.getInstance();
        Singleton secondSingleton = Singleton.getInstance();
        
        out.println("firstSingleton: " + firstSingleton);
        out.println("secondSingleton: " + secondSingleton);
        assertEquals(firstSingleton,secondSingleton);
    }
    
    @Test
    public void testVersionNumber()
    {
        String version = Singleton.getInstance().getVersionNumber();
        assertEquals("2.0.0", version);
    }
}
