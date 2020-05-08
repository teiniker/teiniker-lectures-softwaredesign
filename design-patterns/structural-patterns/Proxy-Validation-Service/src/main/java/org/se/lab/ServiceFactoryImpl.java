package org.se.lab;

class ServiceFactoryImpl // public because a client has to instantiate this class
	implements ServiceFactory
{

	/*
	 * ServiceFactory methods
	 */
	public Service createService()
	{		
		return new ValidationProxy(new ServiceImpl());
	}
}
