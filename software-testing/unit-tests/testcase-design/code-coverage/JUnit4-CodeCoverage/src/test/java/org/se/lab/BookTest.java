package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class BookTest
{
	@Test
	public void testConstructor()
	{
		Book book = new Book("9780132350884", "Robert C. Martin", "Clean Code");

		Assert.assertEquals("9780132350884", book.getIsbn());
		Assert.assertEquals("Robert C. Martin", book.getAuthor());
		Assert.assertEquals("Clean Code", book.getTitle());
	}

	@Test
	public void testToString()
	{
		Book book = new Book("9780132350884", "Robert C. Martin", "Clean Code");

		Assert.assertEquals("Book{isbn='9780132350884', author='Robert C. Martin', title='Clean Code'}", book.toString());
	}

	@Test
	public void testHashCodeAndEquals()
	{
		Book book1 = new Book("9780132350884", "Robert C. Martin", "Clean Code");
		Book book2 = new Book("9780132350884", "Robert C. Martin", "Clean Code");

		Assert.assertFalse(book1 == book2);
		Assert.assertTrue(book1.equals(book2));
		Assert.assertTrue(book2.equals(book1));

		Assert.assertTrue(book1.hashCode() ==  book2.hashCode());
	}

	@Test
	public void testToJson()
	{
		// Setup
		Book book = new Book("9780132350884", "Robert C. Martin", "Clean Code");

		// Exercise
		String json = book.toJson();

		// verify
		String expected = "{\"isbn\":\"9780132350884\",\"author\":\"Robert C. Martin\",\"title\":\"Clean Code\"}";
		Assert.assertEquals(expected, json);

		// Teardown
	}

/*
	@Test
	public void testInvalidIsbn_Blank()
	{
		try
		{
			new Book("", "Robert C. Martin", "Clean Code");
			Assert.fail();
		}
		catch(IllegalArgumentException e)
		{
			Assert.assertEquals("Invalid isbn number!", e.getMessage());
			// passed
		}
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidIsbn_Null()
	{
		new Book(null, "Robert C. Martin", "Clean Code");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidAuthor_Blank()
	{
		new Book("9780132350884", "", "Clean Code");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidAuthor_Null()
	{
		new Book("9780132350884", null, "Clean Code");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidTitle_Blank()
	{
		new Book("9780132350884", "Robert C. Martin", "");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidTitle_Null()
	{
		new Book("9780132350884", "Robert C. Martin", null);
	}
*/
}