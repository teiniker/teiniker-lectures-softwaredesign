package org.se.lab;

import org.se.lab.framework.KBAssert;
import org.se.lab.framework.KBTestCase;

public class StringLengthTest
	extends KBTestCase
{
	public StringLengthTest()
	{
		super("StringLengthTest");
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
		int result = s.length();
		
		KBAssert.assertEquals(5, result);
	}
}
