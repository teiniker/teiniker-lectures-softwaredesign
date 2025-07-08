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
		builder.item("line1").item("line2").item("end of lines");
		String s = builder.toXml();
		
		String expected = 
				"<list>\n"	+
				"	<item>line1</item>\n" +
				"	<item>line2</item>\n" +
				"	<item>end of lines</item>\n" +
				"</list>";
		
		Assert.assertEquals(expected, s);
	}
}
