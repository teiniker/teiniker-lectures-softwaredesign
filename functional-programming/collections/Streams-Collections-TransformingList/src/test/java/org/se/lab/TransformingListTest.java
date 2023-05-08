package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformingListTest
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
            result.add(s.toUpperCase());
        }

        Assert.assertEquals("[Eins, Zwei, Drei, Vier]", list.toString());
        Assert.assertEquals("[EINS, ZWEI, DREI, VIER]", result.toString());
    }

    @Test
    public void testForEach()
    {
        List<String> result = new ArrayList<>();

        // Use internal iterator
        list.forEach(s -> result.add(s.toUpperCase()));

        Assert.assertEquals("[Eins, Zwei, Drei, Vier]", list.toString());
        Assert.assertEquals("[EINS, ZWEI, DREI, VIER]", result.toString());
    }

    @Test
    public void testStream()
    {
        // Use a stream
        List<String> result = list.stream()
                .map(s -> s.toUpperCase())
                .toList();

        Assert.assertEquals("[Eins, Zwei, Drei, Vier]", list.toString());
        Assert.assertEquals("[EINS, ZWEI, DREI, VIER]", result.toString());
    }

    @Test
    public void testStreamAndMethodReference()
    {
        // Use a stream
        List<String> result = list.stream()
                .map(String::toUpperCase)
                .toList();

        Assert.assertEquals("[Eins, Zwei, Drei, Vier]", list.toString());
        Assert.assertEquals("[EINS, ZWEI, DREI, VIER]", result.toString());
    }
}
