package org.se.lab;

public class ServiceException
	extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public ServiceException()
	{
		super("ServiceException");
	}
	
	public ServiceException(Throwable cause)
	{
		super("ServiceException", cause);
	}
}
