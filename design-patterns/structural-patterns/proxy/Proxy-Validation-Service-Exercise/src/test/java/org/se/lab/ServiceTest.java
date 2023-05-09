package org.se.lab;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceTest
{
	private Service service;
	
	@Before
	public void setup()
	{
		service = new ValidationProxy(new ServiceImpl());
	}

	
	@Test
	public void testService()
	{
		Book b1 = new Book(7, "Effective Java", "Joshua Bloch");
		Book b2 = new Book(13, "Java Concurrency in Practice", "Brian Goetz");
		
		service.addBook(b1);
		service.addBook(b2);
		
		Set<Book> books = service.getBooks();
		Assert.assertEquals(2,books.size());
	}
	
		
	@Test
	public void testSet()
	{
		// Note that a Set only stores unique elements!
		Book b1 = new Book(7, "Effective Java", "Joshua Bloch");
		Book b2 = new Book(13, "Java Concurrency in Practice", "Brian Goetz");
		Book b3 = new Book(13, "Java Concurrency in Practice", "Brian Goetz");
		
		service.addBook(b1);
		service.addBook(b2);
		service.addBook(b3);
		
		Set<Book> books = service.getBooks();
		Assert.assertEquals(2,books.size());
	}


	@Test(expected=IllegalArgumentException.class)
	public void testAdd_BookIsNull()
	{
		service.addBook(null);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdd_NegativeId()
	{
		service.addBook(new Book(-7, "Effective Java", "Joshua Bloch"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdd_TitleIsNull()
	{
		service.addBook(new Book(7, null, "Joshua Bloch"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAdd_AuthorIsNull()
	{
		service.addBook(new Book(7, "Effective Java", null));
	}
}
