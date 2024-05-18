package org.se.lab;

import java.util.List;

public interface ListFactory
{
	List<String> createList();		// Factory Method
	
	List<String> createList(Type t); // Factory Method
}
