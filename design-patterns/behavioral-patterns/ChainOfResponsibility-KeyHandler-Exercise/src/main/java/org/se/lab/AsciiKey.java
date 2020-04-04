package org.se.lab;

public class AsciiKey extends KeyEvent
{
	public AsciiKey(char value)
	{
		this.setValue(value);
	}
	
	private char value;
	public char getValue() 
	{
		return value;
	}
	public void setValue(char value) 
	{
		this.value = value;
	}

	
	public String toString()
	{
		return String.valueOf(value);
	}
}
