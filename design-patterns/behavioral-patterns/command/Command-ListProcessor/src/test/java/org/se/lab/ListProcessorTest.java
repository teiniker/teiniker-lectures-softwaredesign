package org.se.lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ListProcessorTest
{
    private List<String> list;
    
    @Before
    public void setup()
    {
        list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    }


    @Test
    public void testToLowerCaseUsingLambda()
    {
        List<String> result = ListProcessor.process(list, (s) -> s.toLowerCase());
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }
}
