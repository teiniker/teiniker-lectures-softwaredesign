package org.se.lab;


public class EchoTaskUsingAttributes
	extends EchoTask
{
	/*
	 * Constructor
	 */
	public EchoTaskUsingAttributes(String message)
	{
		super(message);
	}

	
	public String toXml()
	{
		StringBuilder xml = new StringBuilder();
		xml.append("<echo message=\"");
		xml.append(getMessage());
		xml.append("\"/>");
		return xml.toString();
	}
}
