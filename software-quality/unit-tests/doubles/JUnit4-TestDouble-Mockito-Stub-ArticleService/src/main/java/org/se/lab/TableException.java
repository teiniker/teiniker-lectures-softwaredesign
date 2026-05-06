package org.se.lab;

public class TableException
	extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public TableException()
	{
		super("TableException");
	}
	
	public TableException(String msg)
	{
		super(msg);
	}
}
