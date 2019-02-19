package org.se.lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger
{
	// Singleton
	private Logger() {};
	private final static Logger INSTANCE = new Logger();
	public static Logger getInstance()
	{
		return INSTANCE;
	}
	
	private List<String> logs = new ArrayList<>();
	
	public List<String> getLogList()
	{
		return logs;
	}
	
	public void log(String msg)
	{
		Date now = new Date();
		logs.add("[" + now + "] " + msg);
	}
}
