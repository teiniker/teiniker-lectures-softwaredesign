package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FindingElementsTest
{
    private List<String> list;
    
    @Before
    public void setup()
    {
        list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    }


    @Test
    public void testForLoop()
    {
        List<String> result = new ArrayList<>();

        // Use imperative implementation
        for(String s : list)
        {
            if(s.endsWith("i"))
                result.add(s);
        }

        Assert.assertEquals("[Eins, Zwei, Drei, Vier]", list.toString());
        Assert.assertEquals("[Zwei, Drei]", result.toString());
    }

    @Test
    public void testStream()
    {
        // Use a stream
        List<String> result = list.stream()
                .filter(s -> s.endsWith("i"))
                .toList();

        Assert.assertEquals("[Eins, Zwei, Drei, Vier]", list.toString());
        Assert.assertEquals("[Zwei, Drei]", result.toString());
    }


    @Test
    public void testReusingLambda()
    {
        // We can store a lambda expression in a variable.
        Predicate<String> p = s -> s.endsWith("i");

        // Use a stream
        List<String> result = list.stream()
                .filter(p)
                .toList();

        Assert.assertEquals("[Eins, Zwei, Drei, Vier]", list.toString());
        Assert.assertEquals("[Zwei, Drei]", result.toString());
    }

    @Test
    public void testCountElements()
    {
        // Use a stream
        long result = list.stream()
                .filter(s -> s.endsWith("i"))
                .count();

        Assert.assertEquals("[Eins, Zwei, Drei, Vier]", list.toString());
        Assert.assertEquals(2, result);
    }
}
