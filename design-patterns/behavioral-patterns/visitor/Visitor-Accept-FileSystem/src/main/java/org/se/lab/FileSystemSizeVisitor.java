package org.se.lab;

public class FileSystemSizeVisitor 
	implements FileSystemVisitor
{
	/*
	 * Property: size
	 */
	private long size=0;
	public long getSize()
	{
		return size;
	}

	
	/*
	 * Visitor Methods
	 */

	@Override
	public void visit(File file)
	{
		// operation
		size += file.getSize();
	}

	@Override
	public void visit(Directory dir)
	{
		// operation
	}

	@Override
	public void visit(Node node)
	{
		// operation
	}
}
