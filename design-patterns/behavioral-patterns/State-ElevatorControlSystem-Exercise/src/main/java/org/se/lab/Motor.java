package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Motor
{
	/*
	 * Log actions for validation purposes
	 */
	protected List<String> log = new ArrayList<String>();
	
	
	/*
	 * Operations
	 */
	
	public void runCounterclockwise()
	{
		log.add("counterclockwise");
	}
	
	public void runClockwise()
	{
		log.add("clockwise");
	}
	
	public void stop()
	{
		log.add("stop");
	}
}
