package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class StringBuilderTest
{
	@Test
	public void testStringConcatination()
	{
		String s = "Hello " + "world" + "!";
		
		Assert.assertEquals("Hello world!", s);
	}

	
	@Test
	public void testStringBuilder()
	{
		StringBuilder builder = new StringBuilder();
		
		String s = builder.append("Hello ").append("world").append("!").toString();
		
		Assert.assertEquals("Hello world!", s);
	}
	
	
	@Test
	public void testStringBuffer()
	{
		// StringBuffer methods are synchronized
		StringBuffer buffer = new StringBuffer();
		buffer.append("Hello ").append("world").append("!");
		
		String s = buffer.toString();
		
		Assert.assertEquals("Hello world!", s);
	}
}
