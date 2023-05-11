package org.se.lab;

import org.junit.Test;

public class IntegerSequenceTest
{

	/*
	 * Note that the compiler generates a default constructor, so we have to
	 * test it too :-)
	 * 
	 * In classes with only static methods we make the constructor private 
	 * (or at least protected) to prevent clients from using such a constructor.
	 */
	@Test
	public void testSequence()
	{
		@SuppressWarnings("unused")
		IntegerSequence dummy = new IntegerSequence();
	}
}
