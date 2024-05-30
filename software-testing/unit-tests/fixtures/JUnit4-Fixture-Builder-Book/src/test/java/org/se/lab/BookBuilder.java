package org.se.lab;

public class BookBuilder
{
    private String isbn; ;
    private String author;
    private String title;

    // Builder operations

    public BookBuilder isbn(String isbn)
    {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder author(String author)
    {
        this.author = author;
        return this;
    }

    public BookBuilder title(String title)
    {
        this.title = title;
        return this;
    }

    public Book build()
    {
        return new Book(isbn, author, title);
    }
}
