package org.se.lab;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListProcessorToUpperTest
{
    @Test
    public void testCollectionToUpper()
    {
        List<String> list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
        
        ListProcessor proc = new ListToUpper();
        proc.process(list);
        
        System.out.println(list);
        Assert.assertEquals("[EINS, ZWEI, DREI, VIER]", list.toString());
    }
}
