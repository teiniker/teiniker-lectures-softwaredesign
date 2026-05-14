package org.se.lab;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookTest
{
    private List<Book> table;

    @BeforeEach
    void setup()
    {
        table = List.of(
                new Book("9781680509793", "Venkat Subramaniam", "Functional Programming in Java"),
                new Book("9780132350884", "Robert C. Martin", "Clean Code"),
                new Book("9780134685991", "Joshua Bloch", "Effective Java")
        );
    }

    @Test
    void testFindAllTitles()
    {
        List<String> result = table.parallelStream()
                .map(Book::getTitle)
                .sorted()
                .toList();

        assertAll("sorted titles",
            () -> assertEquals(3, result.size()),
            () -> assertEquals("Clean Code", result.get(0)),
            () -> assertEquals("Effective Java", result.get(1)),
            () -> assertEquals("Functional Programming in Java", result.get(2))
        );
    }

    @Test
    void testFindByIsbn()
    {
        final String ISBN = "9780132350884";
        Optional<Book> result = table.parallelStream()
                .filter(b -> b.getIsbn().equals(ISBN))
                .findAny();

        assertAll("found book",
            () -> assertTrue(result.isPresent()),
            () -> assertEquals("Robert C. Martin", result.get().getAuthor()),
            () -> assertEquals("Clean Code", result.get().getTitle())
        );
    }

    @Test
    void testFindByIsbn_NotFound()
    {
        final String ISBN = "9780132350000";
        Optional<Book> result = table.parallelStream()
                .filter(b -> b.getIsbn().equals(ISBN))
                .findAny();

        assertFalse(result.isPresent());
    }

    @Test
    void testRemoveBook()
    {
        final String ISBN = "9780132350884";
        List<Book> result = table.parallelStream()
                .filter(b -> !b.getIsbn().equals(ISBN))
                .toList();

        assertAll("book removed",
            () -> assertEquals(2, result.size()),
            () -> assertTrue(result.stream().noneMatch(b -> b.getIsbn().equals(ISBN)))
        );
    }

    @Test
    void testInvalidIsbn()
    {
        assertThrows(IllegalArgumentException.class,
                () -> new Book(null, "Author", "Title"));
    }
}
