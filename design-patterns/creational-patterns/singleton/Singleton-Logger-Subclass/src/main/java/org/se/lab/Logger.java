package org.se.lab;

public class Logger
{
	/*
	 * Singleton Pattern
	 */
	protected Logger() {}
	private final static Logger INSTANCE = new AnotherLogger();
	public static Logger getInstance()
	{
		return INSTANCE;
	}

	/*
	 * Operations
	 */
	public void error(String msg)
	{
		print("ERROR: " + msg);		
	}

	public void warning(String msg)
	{
		print("WARNING: " + msg);
	}

	public void info(String msg)
	{
		print("INFO: " + msg);
	}

	public void debug(String msg)
	{
		print("DEBUG: " + msg);
	}

	/*
	 * Utility Methods
	 */
	protected void print(String s)
	{
		System.out.println(s);
	}
}
