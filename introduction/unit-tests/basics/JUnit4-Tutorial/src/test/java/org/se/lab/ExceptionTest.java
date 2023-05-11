package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;


public class ExceptionTest
{
    @Test(expected = IllegalStateException .class)
    public void aMethodWithException()
    {
        out.println("aMethodWithException()");
        throw new IllegalStateException();
    }    


    @Test
    public void aMethodWithExceptionAndMessage()
    {
    	// setup
    	
    	try
    	{
    		// exercise
    		setName(null);
    		fail();
    	}
    	catch(NullPointerException e)
    	{
    		// verify
    		String msg = e.getMessage();
    		assertEquals("Parameter name is null!", msg);
    	}
    	// teardown
    }
    
    
    private void setName(String name)
    {
    	if(name == null)
    		throw new NullPointerException("Parameter name is null!");
    	
    	// do something
    }
}
