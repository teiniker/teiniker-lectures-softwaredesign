package org.se.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeoutTest
{
    @Test
    @Timeout(2) // fail test after 2 seconds
    public void aMethodWithTimeout() throws InterruptedException
    {
        System.out.println("aMethodWithTimeout()");
        Thread.sleep(5000);
    }
}
