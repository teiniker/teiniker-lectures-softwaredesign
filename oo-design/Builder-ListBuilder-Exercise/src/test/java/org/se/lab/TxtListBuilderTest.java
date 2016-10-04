package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class TxtListBuilderTest
{
	@Test
	public void testToText()
	{		
		TxtListBuilder builder = new TxtListBuilder();
		// Director executes single steps to create a product
		builder.item("Hello").item("world").item("!");
		String s = builder.toText();
		
		String expected = 
				"list:\n"	+
				"	- Hello\n" +
				"	- world\n" +
				"	- !\n";
		
		Assert.assertEquals(expected, s);
	}
}
