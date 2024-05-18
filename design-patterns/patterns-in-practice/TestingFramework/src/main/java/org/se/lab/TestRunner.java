package org.se.lab;

import org.se.lab.framework.KBTest;

public class TestRunner
{
	public static void main(String[] args)
	{
		// You can execute single test cases, single test suites
		// or the whole tree of suites and test cases.
		
//		KBTest test = new IntegerMulTest();
//		KBTest test = new IntegerTestSuite();
//		KBTest test = new StringTestSuite();
		KBTest test = new MainTestSuite();
		test.run();
		
		System.out.println("---------------------------------------------");
		for(String s : KBTest.getResults())
		{
			System.out.println(s);
		}
		System.out.println("---------------------------------------------");
	}
}
