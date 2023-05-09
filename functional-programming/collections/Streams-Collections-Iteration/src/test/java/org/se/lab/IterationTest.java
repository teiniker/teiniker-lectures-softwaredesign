package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class IterationTest
{
    private List<String> list;
    
    @Before
    public void setup()
    {
        list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    }


    @Test
    public void testForEachLoop()   // external iterator
    {
        List<String> result = new ArrayList<>();
        for(String s : list)
        {
            System.out.println("s");
        }
    }

    @Test
    public void testForEachMethod() // internal iterator
    {
        list.forEach(s -> System.out.println(s));
    }

    @Test
    public void testForEachMethodAndMethodReference() // internal iterator
    {
        list.forEach(System.out::println);
    }
}
