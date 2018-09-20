package org.se.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IteratorTest
{
   private List<String> list;
    
    @Before
    public void setup()
    {
        list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    }
    
    @Test
    public void testIterator()
    {
        List<String> result = new ArrayList<>();
        
        for(Iterator<String> it = list.iterator(); it.hasNext(); )
        {
            String s = it.next();
            result.add(s.toLowerCase());
        }        
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }
    
    
    @Test
    public void testForEach()
    {
        List<String> result = new ArrayList<>();
        
        for(String s : list )
        {
            result.add(s.toLowerCase());
        }        
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }
    
    
}
