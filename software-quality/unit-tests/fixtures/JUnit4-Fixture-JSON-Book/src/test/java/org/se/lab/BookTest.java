package org.se.lab;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class BookTest
{
	private Book book;

	@Before
	public void setup()
	{
		// Load (complex) object structure from JSON file
		book = loadBookFromJson("book.json");
	}

	@Test
	public void testBook()
	{
		Assert.assertEquals("9780132350884", book.getIsbn());
		Assert.assertEquals("Robert C. Martin", book.getAuthor());
		Assert.assertEquals("Clean Code", book.getTitle());
	}

	// Helper method
	protected Book loadBookFromJson(String filename)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(new File("src/test/resources", filename), Book.class);
		}
		catch (IOException e)
		{
			throw new IllegalStateException("Can't load " + filename + "!", e);
		}
	}
}