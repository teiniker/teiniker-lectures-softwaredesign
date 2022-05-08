package org.se.lab.test;

import org.junit.Before;
import org.se.lab.AbstractTextFileTest;
import org.se.lab.Factory;

class FactoryTest // package-private
	extends AbstractTextFileTest
{
	@Before
	public void setup()
	{
		// new TextFileimpl(); // not visible
		// new VirtualTextFile(); // not visible
		
		file = Factory.INSTANCE.createTextFile("SympathyForTheDevil.txt");
	}
}
