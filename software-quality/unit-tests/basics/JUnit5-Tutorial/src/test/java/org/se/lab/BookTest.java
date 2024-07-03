package org.se.lab;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest
{
    private Book book;

    @BeforeEach
    public void perMethodSetUp()
    {
        book = new Book("9780132350884","Robert C. Martin","Clean Code");
    }

    // If book.getIsbn()() fails, the test stops, and the other assertions are not
    // executed. We only see one failure at a time.
    @Test
    public void testAssertEquals()
    {
        assertEquals("9780132350884", book.getIsbn());
        assertEquals("Robert C. Martin", book.getAuthor());
        assertEquals("Clean Code", book.getTitle());
    }

    // All assertions are executed, and we see all the failures at once, which helps
    // in identifying all the issues with the object being tested in a single test run.
    @Test
    public void testAssertAll()
    {
        assertAll("Book properties",
                () -> assertEquals("9780132350884", book.getIsbn()),
                () -> assertEquals("Robert C. Martin", book.getAuthor()),
                () -> assertEquals("Clean Code", book.getTitle())
        );
    }

}
