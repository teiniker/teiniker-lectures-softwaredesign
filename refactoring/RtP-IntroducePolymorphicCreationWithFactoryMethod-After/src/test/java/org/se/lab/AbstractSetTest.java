package org.se.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public abstract class AbstractSetTest
{
    /*
     * This method should be implemented in each subclass.
     * See factory method pattern.
     */
	public abstract Set<String> createSet();

	@Test
	public void testAdd()
	{
		Set<String> set = createSet();
	
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
		Set<String> set = createSet();
	
		set.add("Kafka");
		assertTrue(set.contains("Kafka"));
	}
}