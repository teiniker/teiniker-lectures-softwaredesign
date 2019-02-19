package org.se.lab.data;

import java.util.concurrent.atomic.AtomicInteger;

public class IntegerSequence
{
    private IntegerSequence() {}
    
    private static AtomicInteger value = new AtomicInteger(1);  // default value
    
    public static int nextValue()
    {
        return value.getAndIncrement();
    }
    
    public static void setInitValue(int initValue)
    {
        value = new AtomicInteger(initValue);
    }
}
