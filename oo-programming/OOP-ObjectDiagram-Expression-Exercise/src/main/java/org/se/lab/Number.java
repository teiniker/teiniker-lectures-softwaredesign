package org.se.lab;

public class Number extends Expression
{
	/*
	 * Constructor
	 */
	public Number(int value)
	{
		setValue(value);
	}
	

	/*
	 * Property: value:int
	 */
	private int value;
	public int getValue()
	{
		return value;
	}
	public void setValue(int value)
	{
		this.value = value;
	}
}
