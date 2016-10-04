package org.se.lab;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.se.lab.example5.Singleton;


public class SingletonEnumTest
{
    @Test
    public void testGetVersion()
    {
        String version = Singleton.INSTANCE.getVersionNumber();
        assertEquals("1.0.0", version);
    }

    
    @Test
    public void testSameObject()
    {
        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;
        assertTrue(s1==s2);
    }
    
    @Test
    public void testEquals()
    {
        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;
        assertTrue(s1.equals(s2));
        assertTrue(s2.equals(s1));
    }
    
}
