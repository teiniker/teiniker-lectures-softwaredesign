package org.se.lab;


public abstract class Logger
{
	/*
	 * Creation Methods
	 */
	
	public static Logger createXmlLogger()
	{
		Logger log = new XmlLogger();
		return log;
	}
	
	public static Logger createTextLogger()
	{
		Logger log = new TextLogger();
		return log;
	}

	
	/*
	 * Log Methods (Template Methods)
	 */
	
	public void logDebug(String message)
	{
		logMessage("DEBUG", message);
	}

	public void logError(String message)
	{
		logMessage("ERROR", message);
	}

	public void logInfo(String message)
	{
		logMessage("INFO", message);
	}

	public void logWarning(String message)
	{
		logMessage("WARNING", message);
	}

	
	/*
	 * This method must be implemented in sub-classes. 
	 */
	protected abstract void logMessage(String level, String message);
}
