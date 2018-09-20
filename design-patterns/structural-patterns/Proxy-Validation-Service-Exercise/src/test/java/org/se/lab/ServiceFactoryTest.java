package org.se.lab;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.Book;
import org.se.lab.Service;
import org.se.lab.ServiceFactory;
import org.se.lab.ServiceFactoryImpl;

public class ServiceFactoryTest
{	
	@Test
	public void testCreateService()
	{
		ServiceFactory factory = new ServiceFactoryImpl();		
		Service service = factory.createService();
		
		Assert.assertNotNull(service);
		Assert.assertTrue(service instanceof ValidationProxy);
	}

	
	@Test
	public void testService()
	{
		ServiceFactory factory = new ServiceFactoryImpl();		
		Service service = factory.createService();

		Book b1 = new Book(7, "Effective Java", "Joshua Bloch");
		Book b2 = new Book(13, "Java Concurrency in Practice", "Brian Goetz");
		
		service.addBook(b1);
		service.addBook(b2);
		
		Set<Book> books = service.getBooks();
		Assert.assertEquals(2,books.size());
	}
}
