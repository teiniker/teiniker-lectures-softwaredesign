package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class ListOfIntegersTest
{
    private Set<String> data;
    
    @Before
    public void setup()
    {
        data = Set.of("23", "12", "66", "7", "17");
    }

    @Test
    public void testStream()
    {
        final int MIN = 10;
        final int MAX = 50;

        List<Integer> result = data.stream()
                .map(Integer::parseInt)
                .filter(i -> i >= MIN && i <= MAX)
                .sorted()
                .toList();

        List<Integer> expected = List.of(12,17,23);
        Assert.assertEquals(expected, result);
    }
}
