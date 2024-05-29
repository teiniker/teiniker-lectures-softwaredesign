package org.se.lab;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListProcessorTest
{
    private List<String> list;
    
    @Before
    public void setup()
    {
        list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    }
    

    @Test
    public void testToLowerCase()
    {
        List<String> result = ListProcessor.process(list);
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }
}
