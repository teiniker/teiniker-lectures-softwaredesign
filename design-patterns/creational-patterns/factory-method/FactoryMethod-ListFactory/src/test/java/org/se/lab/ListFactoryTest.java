package org.se.lab;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListFactoryTest
{
	private ServiceLocator locator = ServiceLocator.getInstance();
	
	@Test
	public void testCreateList()
	{
		//		ListFactory factory = new ListFactoryImpl();
		ListFactory factory = locator.newListFactory();
		
		List<String> list = factory.createList();
		
		list.add("eins");
		list.add("zwei");
		list.add("drei");
		
		Assert.assertEquals(3, list.size());
	}

	@Test
	public void testCreateLinkedList()
	{
		//		ListFactory factory = new ListFactoryImpl();
		ListFactory factory = locator.newListFactory();
		
		List<String> list = factory.createList(Type.LINKED);
		
		list.add("eins");
		list.add("zwei");
		list.add("drei");
		
		Assert.assertEquals(3, list.size());
	}

	@Test
	public void testCreateArrayList()
	{
		//		ListFactory factory = new ListFactoryImpl();
		ListFactory factory = locator.newListFactory();
		
		List<String> list = factory.createList(Type.ARRAY);
		
		list.add("eins");
		list.add("zwei");
		list.add("drei");
		
		Assert.assertEquals(3, list.size());
	}
}
