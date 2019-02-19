package org.se.lab;

public interface Connection
{
	void open();
	
	void close();
	
	void send(String message);
	
	String receive();
}
