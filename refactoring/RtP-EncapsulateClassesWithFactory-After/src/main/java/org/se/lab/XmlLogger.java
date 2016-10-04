package org.se.lab;

import java.util.Date;


class XmlLogger		// package private
	extends Logger
{
	protected void logMessage(String level, String message)
	{
		Date now = new Date();
		String s = "<logmessage timestamp=\"" + now + "\" level=\"" + level + "\" message=\"" + message + "\"/>";
		System.out.println(s);
	}
}
