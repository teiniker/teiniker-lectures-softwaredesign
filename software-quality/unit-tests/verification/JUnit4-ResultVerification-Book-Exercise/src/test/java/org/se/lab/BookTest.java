package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class BookTest
{
	@Test
	public void testAssertEquals()
	{
		Book actual = new Book("9780132350884", "Robert C. Martin", "Clean Code");
		Book expected = new Book("9780132350884", "Robert C. Martin", "Clean Code");

		assertEquals(expected, actual);
	}

	@Test
	public void testEquals()
	{
		Book actual = new Book("9780132350884", "Robert C. Martin", "Clean Code");
		Book expected = new Book("9780132350884", "Robert C. Martin", "Clean Code");

		Assert.assertTrue(equals(expected, actual));
	}

	@Test
	public void testNotEquals_Isbn()
	{
		Book actual = new Book("9780132350884", "Robert C. Martin", "Clean Code");
		Book expected = new Book("0780132350884", "Robert C. Martin", "Clean Code");

		Assert.assertFalse(equals(expected, actual));
	}

	@Test
	public void testNotEquals_Author()
	{
		Book actual = new Book("9780132350884", "Robert C. Martin", "Clean Code");
		Book expected = new Book("9780132350884", "Robert M. Martin", "Clean Code");

		Assert.assertFalse(equals(expected, actual));
	}

	@Test
	public void testNotEquals_Title()
	{
		Book actual = new Book("9780132350884", "Robert C. Martin", "Clean Code");
		Book expected = new Book("9780132350884", "Robert C. Martin", "Clean Kode");

		Assert.assertFalse(equals(expected, actual));
	}

	// TODO: Implement Custom Equal and Assert methods here...

}