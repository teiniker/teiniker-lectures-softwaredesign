package org.se.lab;

public interface Factory
{
	Factory INSTANCE = new FactoryImpl();

	TextFile createTextFile(String filename);
	
}
