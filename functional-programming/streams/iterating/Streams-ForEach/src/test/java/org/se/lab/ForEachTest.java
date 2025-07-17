package org.se.lab;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachTest
{
    private List<String> list;
    
    @Before
    public void setup()
    {
        list = List.of("Eins", "Zwei", "Drei", "Vier");
    }


    @Test
    public void testForEachLoop()   // external iterator
    {
        for(String s : list)
        {
            System.out.println(s);
        }
    }

    @Test
    public void testForEachMethod() // internal iterator
    {
        list.stream().forEach(s -> System.out.println(s));
    }

    @Test
    public void testForEachMethodAndMethodReference() // internal iterator
    {
        list.stream().forEach(System.out::println);
    }
}
