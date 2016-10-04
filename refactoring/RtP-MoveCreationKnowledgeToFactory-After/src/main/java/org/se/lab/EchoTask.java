package org.se.lab;

public abstract class EchoTask
{
	/*
	 * Constructor
	 */
	public EchoTask(String message)
	{
		setMessage(message);
	}
	
	
	/*
	 * Property: message:String
	 */
	private String Message;
	public String getMessage()
	{
		return Message;
	}
	public void setMessage(String message)
	{
		if(message == null)
			throw new IllegalArgumentException("Parameter message is null!");
		Message = message;
	}
	
	
	public abstract String toXml();
}
