package org.se.lab;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StreamTest
{
    private List<String> list;
    
    @Before
    public void setUp()
    {
        list = Arrays.asList("eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun");
    }


    @Test
    public void testForEachWithLambda()
    {
        list.forEach((s) -> System.out.println(s));
    }

    /*
     * Method References
     * The :: operator separates the method name from the name of a class or object.
     * There are three variations:
     * 	- Class::instanceMethod
     * 		The first parameter becomes the receiver of the method, and any other
     * 		parameters are passed to the method.
     *  - Class::staticMethod
     *  	All parameters are passed to the static method.
     *  - object::instanceMethod
     *  	The method is invoked on the given object, and the parameters are passed
     *  	to the instance method. 
     */
    @Test
    public void testForEachWithMethodReference()
    {
        list.forEach(System.out::println); 
    }


    @Test
    public void testCount()
    {
        long count = list.stream().count();
        
        Assert.assertEquals(9, count);
    }

    
    @Test
    public void testSorted()
    {
        List<String> l = list.stream().sorted().collect(Collectors.toList());
        
        Assert.assertEquals("[acht, drei, eins, fünf, neun, sechs, sieben, vier, zwei]", l.toString());
    }

    
    @Test
    public void testMap()
    {
//        List<String> l = list.stream().map((s) -> s.toUpperCase()).collect(Collectors.toList());
        List<String> l = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        
        Assert.assertEquals("[EINS, ZWEI, DREI, VIER, FÜNF, SECHS, SIEBEN, ACHT, NEUN]", l.toString());
    }
    
    @Test
    public void testLimit()
    {
        List<String> l = list.stream().limit(4).collect(Collectors.toList());
        
        Assert.assertEquals("[eins, zwei, drei, vier]", l.toString());
    }
    
    
    @Test
    public void testFilter()
    {
    	long count = list.stream().filter((s) -> s.length() > 4).count();
        
        Assert.assertEquals(2, count);    
    }

       
    @Test
    public void testFilterParallel()
    {
        long count = list.parallelStream().filter((s) -> s.length() > 4).count();
        
        Assert.assertEquals(2, count);
    }
}
