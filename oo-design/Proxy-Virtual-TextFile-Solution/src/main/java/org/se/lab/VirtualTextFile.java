package org.se.lab;

import java.util.List;

class VirtualTextFile  // package private  
	implements TextFile
{
	/*
	 * Constructor
	 */
	public VirtualTextFile(String filename)
	{
		setFilename(filename);
	}
	
	
	/*
	 * Property: filename:String
	 */
	private String filename;
	public String getFilename()
	{
		return filename;
	}
	private void setFilename(String filename)
	{
		if(filename == null)
			throw new IllegalArgumentException();
		this.filename = filename;
	}

	
	/*
	 * Composition: <>---[1]-> impl:TextFileImpl
	 */
	private TextFileImpl impl = null;
	private TextFileImpl getImpl()
	{
		if(impl == null)
			impl = new TextFileImpl(filename);
		return impl;
	}
	
	
	@Override
	public int numberOfLines()
	{
		return getImpl().numberOfLines();
	}

	@Override
	public int length()
	{		
		return getImpl().length();
	}

	@Override
	public String getLine(int i)
	{
		return getImpl().getLine(i);
	}

	@Override
	public List<String> asList()
	{		
		return getImpl().asList();
	}

}
