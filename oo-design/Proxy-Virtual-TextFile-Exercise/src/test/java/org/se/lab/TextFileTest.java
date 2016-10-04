package org.se.lab;

import org.junit.Before;

public class TextFileTest
	extends AbstractTextFileTest
{
	@Before
	public void setup()
	{
		file = new TextFileImpl("SympathyForTheDevil.txt");
	}
}
