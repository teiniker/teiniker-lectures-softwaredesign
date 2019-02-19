package org.se.lab;

public class FileSystemSizeVisitor 
	implements FileSystemVisitor
{
	/*
	 * Property: size
	 */
	private int size=0;
	public int getSize()
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
