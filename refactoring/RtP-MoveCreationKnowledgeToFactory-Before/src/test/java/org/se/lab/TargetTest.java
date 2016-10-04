package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.se.lab.Target;


public class TargetTest
{

	@Test
	public void testTarget1WithText()
	{
		Target target = new Target("info", false);
		target.setName("info");
		target.addInfo("Hello");
		target.addInfo("Kapfenberg!");
		
		String xml = target.toXml();
		System.out.println(xml);
		
		String expected = 
			"<target name=\"info\">\n" + 
			"  <echo>Hello</echo>\n" +
			"  <echo>Kapfenberg!</echo>\n" +
			"</target>";
		assertEquals(expected,xml);
	}

	
	@Test
	public void testTarget1WithAttributes()
	{
		Target target = new Target("info", true);
		target.addInfo("Hello");
		target.addInfo("Kapfenberg!");
		
		String xml = target.toXml();
		System.out.println(xml);
		
		String expected = 
			"<target name=\"info\">\n" + 
			"  <echo message=\"Hello\"/>\n" +
			"  <echo message=\"Kapfenberg!\"/>\n" +
			"</target>";
		assertEquals(expected,xml);
	}
}
