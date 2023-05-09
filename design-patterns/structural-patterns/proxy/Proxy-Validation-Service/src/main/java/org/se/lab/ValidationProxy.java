package org.se.lab;

import java.util.Collections;
import java.util.Set;

class ValidationProxy // package private
	implements Service
{
	/*
	 * Delegation: ---[1]-> Service
	 */
	private Service service;
	
	
	/*
	 * Constructor
	 */
	public ValidationProxy(Service service)
	{
		if(service == null)
			throw new IllegalArgumentException();
		this.service = service;
	}
	
	@Override
	public void addBook(Book book)
	{
		// Pre-procesing
		if(!isValidBook(book))
			throw new IllegalArgumentException();
		
		// Delegate to the implementation
		service.addBook(book);
	}

	@Override
	public Set<Book> getBooks()
	{
		// Delegate to the implementation
		Set<Book> result = service.getBooks(); 
		
		// Post-processing
		return result;
	}
	
	
	/*
	 * Helper methods
	 */
	
	private boolean isValidBook(Book book)
	{
		if(book == null)
			return false;
		
		if(book.getId() < 0)
			return false;
		
		if(book.getTitle() == null)
			return false;
		
		if(book.getAuthor() == null)
			return false;
		
		return true;
	}
}
