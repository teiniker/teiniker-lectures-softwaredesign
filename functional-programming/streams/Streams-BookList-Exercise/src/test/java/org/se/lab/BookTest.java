package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class BookTest
{
    private List<Book> table;
    
    @Before
    public void setup()
    {
        table = List.of(
                    new Book("9781680509793", "Venkat Subramaniam ", "Functional Programming in Java"),
                    new Book("9780132350884", "Robert C. Martin", "Clean Code"),
                    new Book("9780134685991", "Joshua Bloch", "Effective Java")
                    );
    }

    @Test
    public void testFindAllTitles()
    {
        List<String> result = // TODO

        List<String> expected = List.of("Clean Code","Effective Java","Functional Programming in Java");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testFindByIsbn()
    {
        final String ISBN = "9780132350884";

        Optional<Book> result = // TODO

        Assert.assertTrue(result.isPresent());
    }

    @Test
    public void testRemoveBook()
    {
        final String ISBN = "9780132350884";

        List<Book> result = // TODO

        result.forEach(System.out::println);
        Assert.assertEquals(2, result.size());
    }
}
