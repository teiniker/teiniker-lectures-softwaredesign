package org.se.lab;

public class ServiceLocator
{
	/*
	 *  Singleton
	 */
	private ServiceLocator() {}
	private static final ServiceLocator INSTANCE = new ServiceLocator();
	public static ServiceLocator getInstance()
	{
		return INSTANCE;
	}
	
	public ListFactory newListFactory()
	{
		return new ListFactoryImpl();
	}
	
	//...
}
