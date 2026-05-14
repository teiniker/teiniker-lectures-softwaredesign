package org.se.lab;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class ExceptionTest
{
    @Test
    public void aMethodWithException()
    {
        System.out.println("aMethodWithException()");
        assertThrows(IllegalStateException.class, () -> {
            throw new IllegalStateException();
        });
    }


    @Test
    public void aMethodWithExceptionAndMessage()
    {
        // exercise
        NullPointerException exception = assertThrows(NullPointerException.class, () -> {
            setName(null);
        });

        // verify
        String msg = exception.getMessage();
        assertEquals("Parameter name is null!", msg);
    }
    

    private void setName(String name)
    {
        if(name == null)
            throw new NullPointerException("Parameter name is null!");

        // do something
    }
}
