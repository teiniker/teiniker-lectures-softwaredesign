package org.se.lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest
{
    private List<String> list;
    
    @Before
    public void setup()
    {
        list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    }


    @Test
    public void testForEach()
    {
        list.stream().forEach((s) -> System.out.println(s));
    }

    @Test
    public void testMap()
    {
        List<String> l = list.stream().map((s) -> s.toLowerCase()).collect(Collectors.toList());

        Assert.assertEquals("[eins, zwei, drei, vier]", l.toString());
    }

    @Test
    public void testMapUsingMethodReference()
    {
        List<String> l = list.stream().map(String::toLowerCase).collect(Collectors.toList());

        Assert.assertEquals("[eins, zwei, drei, vier]", l.toString());
    }


    @Test
    public void testCount()
    {
        long count = list.stream().count();

        Assert.assertEquals(4, count);
    }


    @Test
    public void testSorted()
    {
        List<String> l = list.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals("[Drei, Eins, Vier, Zwei]", l.toString());
    }


    @Test
    public void testLimit()
    {
        List<String> l = list.stream().limit(2).collect(Collectors.toList());

        Assert.assertEquals("[Eins, Zwei]", l.toString());
    }


    @Test
    public void testFilter()
    {
        list = Arrays.asList("1", "Zwei", "3", "Vier");
        long count = list.stream().filter((s) -> s.length() > 1).count();

        Assert.assertEquals(2, count);
    }

    @Test
    public void testMapUsingParallelStream()
    {
        List<String> l = list.parallelStream().map(String::toLowerCase).collect(Collectors.toList());

        Assert.assertEquals("[eins, zwei, drei, vier]", l.toString());
    }
}
