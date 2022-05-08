package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractTextFileTest
{
	protected TextFile file;
	
	@Test
	public void testNumberOfLines()
	{
		Assert.assertEquals(89, file.numberOfLines());
	}

	@Test
	public void testLength()
	{
		Assert.assertEquals(2038, file.length());
	}

	@Test
	public void testGetLine()
	{
		final String EXPECTED = "Tell me baby, what's my name";		
		Assert.assertEquals(EXPECTED, file.getLine(67));
	}

	@Test
	public void testAsList()
	{
		Assert.assertEquals(89, file.asList().size());
	}	
}
