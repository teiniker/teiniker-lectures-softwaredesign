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
    public void testMapUsingParallelStream()
    {
        List<String> l = list.parallelStream().map(String::toLowerCase).collect(Collectors.toList());

        Assert.assertEquals("[eins, zwei, drei, vier]", l.toString());
    }
}
