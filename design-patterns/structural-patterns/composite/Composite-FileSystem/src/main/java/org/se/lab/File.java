package org.se.lab;

public class File 
	implements Node
{
	/*
	 * Constructor
	 */
	public File(String name, long size)
	{
		setName(name);
		setSize(size);
	}
	
	
	/*
	 * Property: name:String
	 */
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		if(name == null)
			throw new NullPointerException();
		this.name = name;
	}

	
	/*
	 * Property: size:long
	 */
	private long size;
	public void setSize(long size)
	{
		if(size < 0)
			throw new IllegalArgumentException();
		this.size = size;
	}

	/*
	 * API Operations
	 */

	@Override
	public long getSize()
	{
		return size;
	}

	@Override
	public int numberOfFiles()
	{
		return 1;
	}
}
