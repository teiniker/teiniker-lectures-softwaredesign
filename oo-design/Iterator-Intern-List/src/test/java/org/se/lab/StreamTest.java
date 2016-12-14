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
    public void setup()
    {
        list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    }
    
    @Test
    public void testToUpperCaseUsingStream()
    {
        List<String> result = list.stream()
                .map(s -> s.toLowerCase())
                .collect(Collectors.toList());
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }
}
