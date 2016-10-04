package org.se.lab.test;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.Book;
import org.se.lab.Service;
import org.se.lab.ServiceFactory;
import org.se.lab.ServiceFactoryImpl;



public class ServiceTest
{
	private Service service;
	
	@Before
	public void setup()
	{
		ServiceFactory factory = new ServiceFactoryImpl();		
		service = factory.createService();
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
	
	@Test(expected=UnsupportedOperationException.class)
	public void testGetBooks_Readonly()
	{
		Set<Book> books = service.getBooks();
		books.add(new Book(666, "The C Programming Language", "Brian W. Kernighan and Brian W. Kernighan"));
	}
}
