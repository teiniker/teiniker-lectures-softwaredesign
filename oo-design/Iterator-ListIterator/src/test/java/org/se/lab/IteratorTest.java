package org.se.lab;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Before;
import org.junit.Test;

public class IteratorTest
{
    private List<String> list;
    
    @Before
    public void setUp()
    {
        list = Arrays.asList("eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun");
    }
    
    
    @Test
    public void testForEach()
    {
        for(String s : list)
        {
            System.out.println(s);
        }
    }
    
    
    @Test
    public void testIterator()
    {
        for(Iterator<String> it = list.iterator(); it.hasNext(); )
        {
            String s = it.next();
            System.out.println(s);
        }        
    }
    
    @Test
    public void testListIterator()
    {
        for(ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();)
        {
            String s = it.previous();
            System.out.println(s);            
        }        
    }
}
