package org.se.lab;

public class IntegerSequence
{
	/*
	 * Constructor
	 */
	private IntegerSequence() {}

	
	/*
	 * Attributes
	 */
	private static int value;
	
	
	/*
	 * Operations
	 */
	public static int getNextValue()
	{
		return value++;
	}
	
	public static void setInitValue(int initValue)
	{
		if(initValue < 0)
			throw new IllegalArgumentException();
		
		value = initValue;
	}
}
