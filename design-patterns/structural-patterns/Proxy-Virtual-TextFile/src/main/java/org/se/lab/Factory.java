package org.se.lab;

public class Factory
	implements FactoryMethods
{
	/*
	 * Singleton
	 */
	private Factory() {}
	private final static Factory INSTANCE = new Factory();
	public static Factory getInstance() { return INSTANCE; }
	
	
	/*
	 * Factory methods
	 */
	
	@Override
	public TextFile createTextFile(String filename)
	{		
		return new VirtualTextFile(filename);
	}

}
