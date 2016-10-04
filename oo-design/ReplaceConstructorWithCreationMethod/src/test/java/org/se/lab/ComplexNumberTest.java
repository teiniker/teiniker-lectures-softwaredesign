package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.se.lab.ComplexNumber;

public class ComplexNumberTest
{
    private final double DELTA = 0.000001;
    
    @Test
    public void testCartesian()
    {
        ComplexNumber z = 
        	ComplexNumber.createFromCartesian(1.0, 1.0);
        assertEquals(1.0, z.getRe(), DELTA);
        assertEquals(1.0, z.getIm(), DELTA);
    }
    
    @Test
    public void testPolar()
    {
//    	ComplexNumber z1 = new ComplexNumber(1.0, 1.0);
        ComplexNumber z = ComplexNumber.createFromPolar(Math.sqrt(2.0), Math.PI/4.0);
        
        assertEquals(1.0, z.getRe(), DELTA);
        assertEquals(1.0, z.getIm(), DELTA);        
    }
    
    @Test
    public void testAdd()
    {
        ComplexNumber z1 = ComplexNumber.createFromCartesian(1.0, 1.0);
        ComplexNumber z2 = ComplexNumber.createFromPolar(Math.sqrt(2.0), Math.PI/4.0);
        z1.add(z2);
        
        assertEquals(2.0, z1.getRe(), DELTA);
        assertEquals(2.0, z1.getIm(), DELTA);    
    }    
}
