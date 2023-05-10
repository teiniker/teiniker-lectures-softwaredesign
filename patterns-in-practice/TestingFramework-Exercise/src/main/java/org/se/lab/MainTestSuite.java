package org.se.lab;

import org.se.lab.framework.KBTestSuite;

public class MainTestSuite
	extends KBTestSuite
{
	public MainTestSuite()
	{
		super("MainTestSuite");

		addTest(new IntegerTestSuite());
		addTest(new StringTestSuite());
	}
}
