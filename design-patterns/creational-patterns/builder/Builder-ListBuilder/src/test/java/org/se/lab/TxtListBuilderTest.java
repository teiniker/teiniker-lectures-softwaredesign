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
		builder.item("line1").item("line2").item("end of line");
		String s = builder.toText();
		
		String expected = 
				"list:\n"	+
				"	- line1\n" +
				"	- line2\n" +
				"	- end of line\n";
		
		Assert.assertEquals(expected, s);
	}
}
