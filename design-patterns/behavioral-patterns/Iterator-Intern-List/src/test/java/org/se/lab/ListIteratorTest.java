package org.se.lab;


import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListIteratorTest
{
    private List<String> list;
    
    @Before
    public void setup()
    {
        list = Arrays.asList("Eins", "Zwei", "Drei", "Vier");
    }
    
    @Test
    public void testToLowerCaseUsingCommand()
    {
        List<String> result = ListIterator.apply(list, new ToLowerOperation());
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }

    
    @Test
    public void testToLowerCaseUsingAnonymousClass()
    {
        List<String> result = ListIterator.apply(list,
                new Operation() {
                    public String execute(String s)
                    {
                        return s.toLowerCase();
                    }
                });
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }

    @Test
    public void testToLowerCaseUsingLambda()
    {
        List<String> result = ListIterator.apply(list, (s) -> s.toLowerCase());
        
        Assert.assertEquals("[eins, zwei, drei, vier]", result.toString());
    }

    @Test
    public void testForEachAndLambda()
    {
//        list.forEach((s) -> System.out.println(s));
        list.forEach(System.out::println);
    }

}
