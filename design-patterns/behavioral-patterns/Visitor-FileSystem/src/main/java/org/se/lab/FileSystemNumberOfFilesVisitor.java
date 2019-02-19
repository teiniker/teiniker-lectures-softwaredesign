package org.se.lab;

public class FileSystemNumberOfFilesVisitor 
	extends FileSystemVisitor
{
	/*
	 * Property: numberOfFiles
	 */
	private int numberOfFiles=0;
	public int getNumberOfFiles()
	{
		return numberOfFiles;
	}

	@Override
	public void visit(File file)
	{
		// Operation
		numberOfFiles += 1;

		// Navigation
	}

	@Override
	public void visit(Directory dir)
	{
		// Operation

		// Navigation
		for(Node n : dir.getNodes())
		{
			visit(n);
		}
	}
}
