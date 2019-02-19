package org.se.lab;

import org.se.lab.framework.KBTestSuite;

public class StringTestSuite
	extends KBTestSuite
{
	public StringTestSuite()
	{
		super("StringTestSuite");

		addTest(new StringLengthTest());
		addTest(new StringToUpperTest());
	}
}
