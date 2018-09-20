package org.se.lab.framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KBTestSuite
	extends KBTest
{
	/*
	 * Constructor
	 */	
	public KBTestSuite(String name)
	{
		super(name);
	}
	
	
	/*
	 * Association: ---[*]-> tests:Test
	 */
	private List<KBTest> tests = new ArrayList<KBTest>();
	public void addTest(KBTest test)
	{
		if(test == null)
			throw new IllegalArgumentException();
		tests.add(test);
	}
	public List<KBTest> getTests()
	{
		return Collections.unmodifiableList(tests);
	}
	
	
	@Override
	public void run()
	{
		System.out.println("KBTestSuite: " + getName());
		for(KBTest t : getTests())
		{
			t.run();
		}		
	}
}
