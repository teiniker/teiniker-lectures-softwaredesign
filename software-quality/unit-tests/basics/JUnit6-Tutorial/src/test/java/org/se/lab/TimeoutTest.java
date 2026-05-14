package org.se.lab;

import static java.lang.System.out;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


public class TimeoutTest
{
    @Test
    @Timeout(1) // fail test after 1 second
    public void aMethodWithTimeout() throws InterruptedException
    {
        out.println("aMethodWithTimeout()");
        Thread.sleep(5000);
    }
}
