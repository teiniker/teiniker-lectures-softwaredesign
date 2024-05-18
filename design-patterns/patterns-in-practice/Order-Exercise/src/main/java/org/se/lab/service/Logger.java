package org.se.lab.service;

import java.util.ArrayList;
import java.util.List;

public class Logger 
{
	/*
	 * Singleton Pattern
	 */
	private Logger() {}	
	private final static Logger INSTANCE = new Logger();
	public static Logger getInstance()
	{
		return INSTANCE;
	}
	
	
	
	private final List<String> log = new ArrayList<String>();
	
	public void debug(String log)
	{
		this.log.add(log);
	}
	
	public List<String> getLogList()
	{
		return log;
	}

	public void emptyLogList()
	{
	    log.clear();
	}
}
