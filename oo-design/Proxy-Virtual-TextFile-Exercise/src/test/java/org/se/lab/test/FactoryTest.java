package org.se.lab.test;

import org.junit.Before;
import org.se.lab.AbstractTextFileTest;
import org.se.lab.Factory;

public class FactoryTest
	extends AbstractTextFileTest
{
	@Before
	public void setup()
	{
		// new TextFileimpl(); // not visible
		// new VirtualTextFile(); // not visible
		
		file = Factory.getInstance().createTextFile("SympathyForTheDevil.txt");
	}
}
