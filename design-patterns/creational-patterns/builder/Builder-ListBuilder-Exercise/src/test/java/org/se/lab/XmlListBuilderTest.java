package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class XmlListBuilderTest
{
	
	@Test
	public void testToXml()
	{		
		XmlListBuilder builder = new XmlListBuilder();
		// Director executes single steps to create a product
		builder.item("Hello").item("world").item("!");
		String s = builder.toXml();
		
		String expected = 
				"<list>\n"	+
				"	<item>Hello</item>\n" +
				"	<item>world</item>\n" +
				"	<item>!</item>\n" +
				"</list>";
		
		Assert.assertEquals(expected, s);
	}
}
