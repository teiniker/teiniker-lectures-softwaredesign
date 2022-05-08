package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ConnectionImpl
	implements Connection
{
	// log state history 
	private List<String> out = new ArrayList<String>();
	public List<String> getOutput()
	{
		return out;
	}
	public void resetOutput()
	{
		out.clear();
	}
	public void printOutput(String s)
	{
		out.add(s);
	}
	
	
	public void close()
	{
		printOutput("close()");
	}

	public void open()
	{
		printOutput("open()");
	}

	public String receive()
	{
		printOutput("receive()");
		return "Hello World!";
	}

	public void send(String message)
	{
		printOutput("send(\"" + message + "\")");
	}
}
