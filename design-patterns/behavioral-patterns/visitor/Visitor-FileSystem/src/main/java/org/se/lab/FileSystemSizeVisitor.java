package org.se.lab;

public class FileSystemSizeVisitor 
	extends FileSystemVisitor
{
	/*
	 * Property: size
	 */
	private long size=0;
	public long getSize()
	{
		return size;
	}

	@Override
	public void visit(File file)
	{
		// operation
		size += file.getSize();
		
		// navigation
	}

	@Override
	public void visit(Directory dir)
	{
		// operation
		
		// navigation
		dir.getNodes().forEach(n -> visit(n));
	}
}
