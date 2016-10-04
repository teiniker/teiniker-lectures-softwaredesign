package org.se.lab.framework;

public class KBAssertionException
	extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public KBAssertionException(String message)
	{
		super(message);
	}

	public KBAssertionException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
