package org.se.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class ForEachTest
{
    private List<String> list;
    
    @Before
    public void setUp()
    {
        list = Arrays.asList("eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun");
    }
    

    @Test
    public void testIterableForEach()
    {
    	// Performs the given action for each element of the Iterable
        // until all elements have been processed or the action throws an
        // exception.
        // void forEach(Consumer<? super T> action)
        // Consumer<T>: void accept(T t);
    	list.forEach(s -> System.out.println(s));
    }
    
    @Test
    public void testIterableForEachMethodReference()
    {
    	// Performs the given action for each element of the Iterable
        // until all elements have been processed or the action throws an
        // exception.
    	list.forEach(System.out::println);
    }
}
