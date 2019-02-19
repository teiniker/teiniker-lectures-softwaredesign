package org.se.lab.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class KBTest
{
	/*
	 * Constructor
	 */
	public KBTest(String name)
	{
		setName(name);
	}
	
	
	public abstract void run();

	public void setUp() 
	{
	};

	public void test()
	{
		KBAssert.fail();
	}

	public void tearDown() 
	{
	};
	
	
	/*
	 * Property: name:String
	 */
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		if(name == null)
			throw new IllegalArgumentException();
		this.name = name;
	}

	
	/*
	 * Property: results:String[*]
	 */
	private static List<String> results = new ArrayList<String>();
	public static void addResult(String result)
	{
		if(result == null)
			throw new IllegalArgumentException();
		results.add(result);
	}
	public static List<String> getResults()
	{
		return Collections.unmodifiableList(results);
	}	
}
