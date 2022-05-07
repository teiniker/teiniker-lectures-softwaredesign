package org.se.lab;

import java.util.List;

public interface ListFactory
{
	List<String> createList();
	
	List<String> createList(Type t);
}
