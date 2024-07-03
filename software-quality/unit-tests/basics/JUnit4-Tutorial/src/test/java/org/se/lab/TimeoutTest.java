package org.se.lab;

import static java.lang.System.out;

import org.junit.Test;


public class TimeoutTest
{
    @Test(timeout = 1000)
    public void aMethodWithTimeout()
    {
        out.println("aMethodWithTimeout()");
        while(true);
    }
}
