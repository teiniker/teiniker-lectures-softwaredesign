package org.se.lab;

import java.util.HashSet;
import java.util.Set;

class ServiceImpl // package private
	implements Service
{

	private Set<Book> books = new HashSet<Book>();
			
	public void addBook(Book book)
	{
		books.add(book);		
	}
	
	
	public Set<Book> getBooks()
	{		
		return books;
	}
}
