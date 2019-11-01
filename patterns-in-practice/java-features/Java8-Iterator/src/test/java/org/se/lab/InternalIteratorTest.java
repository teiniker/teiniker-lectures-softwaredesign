package org.se.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class InternalIteratorTest
{
    private List<String> list;
    
    @Before
    public void setUp()
    {
        list = Arrays.asList("eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun");
    }
    
    @Test
    public void testAnonymousClass()
    {
    	InternalListIterator.forEach(list, new Command(){
    		public String modify(String s)
			{
				return s.toUpperCase();
			}		
    	});
    
    	Assert.assertEquals("[EINS, ZWEI, DREI, VIER, FÜNF, SECHS, SIEBEN, ACHT, NEUN]", 
    			list.toString());
    }

    
    @Test
    public void testLambda()
    {
    	InternalListIterator.forEach(list, (s) -> s.toUpperCase());
    
    	Assert.assertEquals("[EINS, ZWEI, DREI, VIER, FÜNF, SECHS, SIEBEN, ACHT, NEUN]", 
    			list.toString());
    }

    
    @Test
    public void testLambdaMethodReference()
    {
    	InternalListIterator.forEach(list, String::toUpperCase);
    
    	Assert.assertEquals("[EINS, ZWEI, DREI, VIER, FÜNF, SECHS, SIEBEN, ACHT, NEUN]", 
    			list.toString());
    }
}
