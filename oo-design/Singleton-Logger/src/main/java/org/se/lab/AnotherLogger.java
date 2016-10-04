package org.se.lab;

import java.util.Date;

class AnotherLogger	// package private
	extends Logger
{
	protected AnotherLogger()
	{
		super();
	}
	
	
	@Override
	public void debug(String msg)
	{
		System.out.println(new Date() + " [" + Thread.currentThread().getId() + "] DEBUG: " + msg);
	}
	
	// ...
}
