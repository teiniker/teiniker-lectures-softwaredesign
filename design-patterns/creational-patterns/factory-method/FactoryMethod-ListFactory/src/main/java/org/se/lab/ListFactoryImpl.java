package org.se.lab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ListFactoryImpl // package private
	implements ListFactory
{
	@Override
	public List<String> createList()
	{
		return createList(Type.ARRAY);
	}	
	
	@Override
	public List<String> createList(Type t)
	{
		switch(t)
		{
			case ARRAY: 
				return new ArrayList<String>();
			
			case LINKED:
				return new LinkedList<String>();
				
			default:
				throw new IllegalStateException();
		}
	}
}
