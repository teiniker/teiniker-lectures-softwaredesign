package org.se.lab.framework;

public final class KBAssert
{
	private KBAssert() {}
	
	public static void assertEquals(String expected, String actual)
	{
		if(!expected.equals(actual))
			throw new KBAssertionException("Expected " + expected + " but was " + actual + "!");
	}

	public static void assertEquals(int expected, int actual)
	{
		if(expected != actual)
			throw new KBAssertionException("Expected " + expected + " but was " + actual + "!");
	}

	public static void assertTrue(boolean expression)
	{
		if(!expression)
			throw new KBAssertionException("Expected true but was false!");
	}
	
	public static void fail()
	{
		throw new KBAssertionException("Failed!");
	}
}
