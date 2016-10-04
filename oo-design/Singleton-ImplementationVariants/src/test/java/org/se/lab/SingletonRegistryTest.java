package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.se.lab.example3.Singleton;
import org.se.lab.example3.Singleton2;
import org.se.lab.example3.Singleton3;


public class SingletonRegistryTest
{
    @BeforeClass
    public static void setUp()
    {
        Singleton.register("Version2", new Singleton2());
        Singleton.register("Version3", new Singleton3());
    }
    
    @After
    public void resetSingleton()
    {
        Singleton.reset();
    }
    

    @Test
    public void testSingleton()
    {        
        Singleton singleton = Singleton.getInstance();
        assertTrue(singleton instanceof Singleton);
        assertEquals("1.0.0", Singleton.getInstance().getVersionNumber());
    }

    @Test
    public void testSingleton2()
    {        
        System.setProperty("Singleton", "Version2");
        Singleton singleton = Singleton.getInstance();
        assertTrue(singleton instanceof Singleton2);
        assertEquals("2.0.0", Singleton.getInstance().getVersionNumber());
    }
    
    @Test
    public void testSingleton3()
    {        
        System.setProperty("Singleton", "Version3");
        Singleton singleton = Singleton.getInstance();
        assertTrue(singleton instanceof Singleton3);
        assertEquals("3.0.0", Singleton.getInstance().getVersionNumber());
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
}
