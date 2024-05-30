package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest
{
	private Book book;

	@Before
	public void setup()
	{
		book = new BookBuilder()
				.isbn("9780132350884")
				.author("Robert C. Martin")
				.title("Clean Code")
				.build();
	}

	@Test
	public void testConstructor()
	{
		Assert.assertEquals("9780132350884", book.getIsbn());
		Assert.assertEquals("Robert C. Martin", book.getAuthor());
		Assert.assertEquals("Clean Code", book.getTitle());
	}

	@Test
	public void testToString()
	{
		Assert.assertEquals("Book{isbn='9780132350884', author='Robert C. Martin', title='Clean Code'}", book.toString());
	}

	@Test
	public void testHashCodeAndEquals()
	{
		Book book2 = new BookBuilder()
				.isbn("9780132350884").author("Robert C. Martin").title("Clean Code")
				.build();

		Assert.assertFalse(book == book2);
		Assert.assertTrue(book.equals(book2));
		Assert.assertTrue(book2.equals(book));

		Assert.assertTrue(book.hashCode() ==  book2.hashCode());
	}

	@Test
	public void testToJson()
	{
		// Exercise
		String json = book.toJson();

		// verify
		String expected = "{\"isbn\":\"9780132350884\",\"author\":\"Robert C. Martin\",\"title\":\"Clean Code\"}";
		Assert.assertEquals(expected, json);

		// Teardown
	}
}