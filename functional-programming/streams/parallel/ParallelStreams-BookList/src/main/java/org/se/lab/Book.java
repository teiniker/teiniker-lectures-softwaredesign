package org.se.lab;

public class Book
{
	public Book(String isbn, String author, String title)
	{
		setIsbn(isbn);
		setAuthor(author);
		setTitle(title);
	}

	 // Property: isbn:String
	private String isbn;
	public String getIsbn()
	{
		return isbn;
	}
	public void setIsbn(String isbn)
	{
		// Input validation (check pre-conditions)
		if(isbn == null || isbn.isBlank())
			throw new IllegalArgumentException("Invalid isbn number!");

		this.isbn = isbn;
	}

	 // Property: author:String
	private String author;
	public String getAuthor()
	{
		return author;
	}
	public void setAuthor(String author)
	{
		// Input validation (check pre-conditions)
		if(author == null || author.isBlank())
			throw new IllegalArgumentException("Invalid author!");

		this.author = author;
	}

	 // Property: title:String
	private String title;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		// Input validation (check pre-conditions)
		if(title == null || title.isBlank())
			throw new IllegalArgumentException("Invalid title!");

		this.title = title;
	}

	public String toJson()
	{
		return "{" +
				"\"isbn\":\"" + isbn + "\"," +
				"\"author\":\"" + author.replace("\"", "\\\"") + "\"," +
				"\"title\":\"" + title.replace("\"", "\\\"") + "\"" +
				"}";
	}

	 // Object methods
	@Override
	public String toString()
	{
		return "Book{" +
				"isbn='" + isbn + '\'' +
				", author='" + author +
				"', title='" + title +
				"'}";
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

	@Override
	public int hashCode()
	{
		return isbn.hashCode();
	}
}
