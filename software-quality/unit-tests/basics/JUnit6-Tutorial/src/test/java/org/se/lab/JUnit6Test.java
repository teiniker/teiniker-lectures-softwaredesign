package org.se.lab;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class JUnit6Test
{
    @BeforeAll
    public static void perClassSetUp()
    {
        out.println("perClassSetUp()");
    }

    @AfterAll
    public static void perClassTearDown()
    {
        out.println("perClassTearDown()");
    }


    @BeforeEach
    public void perMethodSetUp()
    {
        out.println("perMethodSetUp()");
    }

    @AfterEach
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


//    @Disabled("Until bug #666 is fixed!")
    @Test
    public void anotherMethod()
    {
        out.println("anotherMethod()");
        assertFalse(false);
    }
}
