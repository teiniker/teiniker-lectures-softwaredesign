package org.se.lab;


public class EchoTaskUsingText
	extends EchoTask
{
	/*
	 * Constructor
	 */
	public EchoTaskUsingText(String message)
	{
		super(message);
	}

	
	public String toXml()
	{
		StringBuilder xml = new StringBuilder();
		xml.append("<echo>");
		xml.append(getMessage());
		xml.append("</echo>");
		return xml.toString();
	}
}
