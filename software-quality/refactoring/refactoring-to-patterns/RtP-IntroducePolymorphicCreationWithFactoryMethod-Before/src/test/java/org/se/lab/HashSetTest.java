package org.se.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class HashSetTest
{

	@Test
	public void testAdd()
	{
		Set<String> set = new HashSet<String>();

		set.add("Kafka");
		set.add("Bernhard");
		set.add("Horvath");
		set.add("Kafka");
		System.out.println(set);
		assertEquals(3, set.size());
	}
	
	@Test
	public void testContains()
	{
		Set<String> set = new HashSet<String>();

		set.add("Kafka");
		assertTrue(set.contains("Kafka"));
	}
}
