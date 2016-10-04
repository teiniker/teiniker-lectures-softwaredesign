package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.se.lab.EchoTask;
import org.se.lab.EchoTaskUsingAttributes;
import org.se.lab.EchoTaskUsingText;


public class EchoTaskTest
{

	@Test
	public void testEchoTaskUsingText()
	{
		String message = "Hello Kapfenberg!";
		EchoTask task = new EchoTaskUsingText(message);
		String xml = task.toXml();
		System.out.println(xml);
		String expected = "<echo>Hello Kapfenberg!</echo>";
		assertEquals(expected,xml);
	}
	
	
	@Test
	public void testEchoTaskUsingAttributes()
	{
		String message = "Hello Kapfenberg!";
		EchoTask task = new EchoTaskUsingAttributes(message);
		String xml = task.toXml();
		System.out.println(xml);
		String expected = "<echo message=\"Hello Kapfenberg!\"/>";
		assertEquals(expected,xml);
	}
}
