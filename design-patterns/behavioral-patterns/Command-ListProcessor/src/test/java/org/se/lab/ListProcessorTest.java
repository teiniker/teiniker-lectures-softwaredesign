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
    public void testToLowerCaseUsingCommand()
    {
        List<String> result = ListProcessor.process(list, new ToLowerCommand());
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }

    
    @Test
    public void testToLowerCaseUsingAnonymousClass()
    {
        List<String> result = ListProcessor.process(list,
                new Command() {
                    public String process(String s)
                    {
                        return s.toLowerCase();
                    }
                });
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }

    @Test
    public void testToLowerCaseUsingLambda()
    {
        List<String> result = ListProcessor.process(list, (s) -> s.toLowerCase());
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }
    
}
