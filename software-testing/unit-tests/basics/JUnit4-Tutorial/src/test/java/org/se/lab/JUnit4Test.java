package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


public class JUnit4Test
{
    @BeforeClass
    public static void perClassSetUp()
    {
        out.println("perClassSetUp()");
    }
    
    @AfterClass
    public static void perClassTearDown()
    {
        out.println("perClassTearDown()");
    }
    
    
    @Before
    public void perMethodSetUp()
    {
        out.println("perMethodSetUp()");
    }
    
    @After
    public void perMethodTearDown()
    {
        out.println("perMethodTearDown()");
    }
    
    
    @Test
    public void aMethod()
    {
        out.println("aMethod()");
        assertTrue(true);
    }


    @Ignore
    @Test
    public void anotherMethod()
    {
        out.println("anotherMethod()");
        assertFalse(false);
    }
}
