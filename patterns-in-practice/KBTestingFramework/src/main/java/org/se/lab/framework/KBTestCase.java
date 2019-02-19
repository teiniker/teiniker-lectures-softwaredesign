package org.se.lab.framework;

public class KBTestCase
	extends KBTest
{
	/*
	 * Constructor
	 */
	public KBTestCase(String name)
	{
		super(name);
	}
	
	@Override
	public final void run()
	{
		System.out.println("KBTestCase: " + getName());
		setUp();
		try
		{
			test();
			// OK
			addResult(" test " + getName() + " passed.");
		}
		catch(Exception e)
		{
			// failed
			addResult(" test " + getName() + " failed: " + e.getMessage());
		}
		finally
		{
			tearDown();
		}		
	}	
}
