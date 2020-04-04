package org.se.lab;

public class ControlKey extends KeyEvent
{
	public ControlKey(ValidValues value)
	{
		this.setValue(value);
	}
	
	public enum ValidValues 
	{ 
		CTRL_C, CTRL_V, CTRL_Z, CTRL_Y;
	};
	
	
	private ValidValues value;
	public ValidValues getValue() 
	{
		return value;
	}
	public void setValue(ValidValues value) 
	{
		this.value = value;
	}
	
	
	public String toString()
	{
		return value.toString();
	}		
}
