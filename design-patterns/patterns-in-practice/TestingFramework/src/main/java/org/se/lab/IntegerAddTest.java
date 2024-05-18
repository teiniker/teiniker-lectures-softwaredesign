package org.se.lab;

import org.se.lab.framework.KBAssert;
import org.se.lab.framework.KBTestCase;

public class IntegerAddTest
	extends KBTestCase
{
	private int a;
	private int b;

	public IntegerAddTest()
	{
		super("IntegerAddTest");
	}
	
	public void setUp()
	{
		System.out.println("setUp()");
		a = 3;
		b = 7;
	}
	
	public void tearDown()
	{
		System.out.println("tearDown()");
		a = b = 0;
	}
	
	public void test()
	{
		System.out.println("test()");
		int result = a+b;
		
		KBAssert.assertEquals(3+7, result);
	}
}
