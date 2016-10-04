package org.se.lab;

import java.util.Date;



public class TextLogger
	extends Logger
{
	protected void logMessage(String level, String message)
	{
		Date now = new Date();
		System.out.println("[" + now + "] " + level + ": " + message);
	}
}
