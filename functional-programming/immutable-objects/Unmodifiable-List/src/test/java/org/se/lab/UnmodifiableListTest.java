package org.se.lab;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Assert;
import org.junit.Test;

public class UnmodifiableListTest
{
	private List<String> list = List.of("Homer", "Marge", "Bart", "Lisa", "Maggie");

	@Test
	public void testOf()
	{
		Assert.assertEquals("Marge", list.get(1));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testSet()
	{
		list.set(1,"Apu");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testAdd()
	{
		list.add("Apu");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testRemove()
	{
		list.remove(0);
	}
}
