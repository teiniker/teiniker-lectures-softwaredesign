package org.se.lab;

import java.util.Set;

public interface Service
{
	void addBook(Book book);
	Set<Book> getBooks();
}
