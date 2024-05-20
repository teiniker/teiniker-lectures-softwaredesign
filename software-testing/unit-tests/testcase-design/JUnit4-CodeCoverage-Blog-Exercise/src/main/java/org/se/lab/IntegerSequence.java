package org.se.lab;

public class IntegerSequence
{
	protected IntegerSequence() {}
	
	private static int sequence = 1;
	
	synchronized public static int nextValue()
	{
		return sequence++;
	}
	
	synchronized public static void setValue(int value)
	{
		sequence = value;
	}
}
