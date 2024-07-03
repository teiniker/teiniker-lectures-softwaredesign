package org.se.lab;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
