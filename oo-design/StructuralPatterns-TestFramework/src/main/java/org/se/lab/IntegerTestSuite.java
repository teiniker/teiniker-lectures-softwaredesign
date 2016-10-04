package org.se.lab;

import org.se.lab.framework.KBTestSuite;

public class IntegerTestSuite
	extends KBTestSuite
{
	public IntegerTestSuite()
	{
		super("IntegerTestSuite");

		addTest(new IntegerAddTest());
		addTest(new IntegerMulTest());
	}
}
