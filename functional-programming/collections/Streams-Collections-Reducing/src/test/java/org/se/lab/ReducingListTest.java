package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReducingListTest
{
    @Test
    public void testCountCharacters()
    {
        List<String> list = Arrays.asList("00001111", "0011", "0000011111", "01");
        int sum = list.stream()
                .mapToInt(s -> s.length())
                .sum();

        Assert.assertEquals(24, sum);
    }

    @Test
    public void testReduce()
    {
        List<String> list = Arrays.asList("00001111", "0011", "0000011111", "01");

        Optional<String> longString = list.stream()
                .reduce((s1,s2) -> s1.length() > s2.length() ? s1 : s2);

        longString.ifPresent(s -> System.out.printf("The longest string is '%s'\n", s));
        Assert.assertTrue(longString.isPresent());
        Assert.assertEquals("0000011111", longString.get());
    }

}
