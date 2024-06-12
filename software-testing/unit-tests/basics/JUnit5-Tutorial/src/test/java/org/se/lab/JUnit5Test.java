package org.se.lab;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5Test
{
    @BeforeAll
    public static void perClassSetUp()
    {
        System.out.println("Class SetUp()");
    }
    
    @AfterAll
    public static void perClassTearDown()
    {
        System.out.println("Class TearDown()");
    }
    
    
    @BeforeEach
    public void perMethodSetUp()
    {
        System.out.println("Method SetUp()");
    }
    
    @AfterEach
    public void perMethodTearDown()
    {
        System.out.println("Method TearDown()");
    }
    
    
    @Test
    public void TestaMethod()
    {
        System.out.println("Test aMethod()");
        assertTrue(true);
    }


    @Test
    public void testAnotherMethod()
    {
        System.out.println("Test anotherMethod()");
        assertFalse(false);
    }

    @Disabled("Until bug #666 is fixed!")
    @Test
    public void testIgnoredMethod()
    {
        System.out.println("ignoredMethod()");
        assertFalse(false);
    }
}
