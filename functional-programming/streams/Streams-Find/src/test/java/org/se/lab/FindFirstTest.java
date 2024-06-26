package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindFirstTest
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
        String result = null;

        // Use imperative implementation
        for(String s : list)
        {
            if(s.startsWith("Z"))
            {
                result = s;
                break;
            }
        }

        Assert.assertEquals("Zwei", result);
    }

    @Test
    public void testStreamOptional()
    {
        // Use a stream
        Optional<String> result = list.stream()
                .filter(s -> s.startsWith("Z"))
                .findFirst();

        result.ifPresent(s -> System.out.println(s));

        String finalResult = result.orElse("");

        Assert.assertEquals("Zwei", finalResult);
    }

    @Test
    public void testStreamOptionalElse()
    {
        // Use a stream
        Optional<String> result = list.stream()
                .filter(s -> s.startsWith("X"))
                .findFirst();

        String finalResult = result.orElse("");
        Assert.assertEquals("", finalResult);
    }

}
