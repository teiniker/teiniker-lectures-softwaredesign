package org.se.lab;

public class File 
	extends Node
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

		
	@Override
	public int numberOfFiles()
	{
		return 1;
	}
	
	@Override
	public long getSize()
	{
		return size;
	}

	
	/*
	 * Object methods
	 */

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (size ^ (size >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	public String toString()
	{
		return getName();
	}
}
