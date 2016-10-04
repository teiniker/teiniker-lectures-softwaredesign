package org.se.lab;

import static org.junit.Assert.*;
import static java.lang.System.out;

import org.junit.Test;
import org.se.lab.example4.Singleton;


public class SingletonTest
{

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
        assertEquals("1.1.7", version);
    }
}
