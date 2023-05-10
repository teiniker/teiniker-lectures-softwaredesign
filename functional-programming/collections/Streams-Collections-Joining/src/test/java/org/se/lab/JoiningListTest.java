package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JoiningListTest
{
    List<String> list;

    @Before
    public void setup()
    {
        list = List.of("00001111", "0011", "0000011111", "01");
    }

    @Test
    public void testCollectorsJoin()
    {
        String result = list.stream()
                .collect(Collectors.joining(","));
        Assert.assertEquals("00001111,0011,0000011111,01", result);
    }

    @Test
    public void testStringJoin()
    {
        String result = String.join(",", list);
        Assert.assertEquals("00001111,0011,0000011111,01", result);
    }
}
