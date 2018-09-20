package org.se.lab;

import org.se.lab.framework.KBAssert;
import org.se.lab.framework.KBTestCase;

public class StringToUpperTest
	extends KBTestCase
{
	public StringToUpperTest()
	{
		super("StringToUpperTest");
	}
	
	public void setUp()
	{
		System.out.println("setUp()");
	}
	
	public void tearDown()
	{
		System.out.println("tearDown()");
	}

	
	public void test()
	{
		System.out.println("test()");
		
		String s = "Hello KBerg!";
		String result = s.toUpperCase();
		
		KBAssert.assertEquals("HELLO KBERG!", result);
	}
}
