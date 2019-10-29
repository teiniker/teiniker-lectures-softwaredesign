package org.se.lab;

class FactoryImpl
	implements Factory
{

	/*
	 * Factory methods
	 */
	
	@Override
	public TextFile createTextFile(String filename)
	{		
		return new VirtualTextFile(filename);
	}

}
