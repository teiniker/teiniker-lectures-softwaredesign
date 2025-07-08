package org.se.lab;

public class FileSystemNumberOfFilesVisitor 
	implements FileSystemVisitor
{
	/*
	 * Property: numberOfFiles
	 */
	private int numberOfFiles=0;
	public int getNumberOfFiles()
	{
		return numberOfFiles;
	}

	
	/*
	 * Visitor Methods
	 */
	
	@Override
	public void visit(File file)
	{
		numberOfFiles++;
	}

	@Override
	public void visit(Directory dir)
	{
	}

	@Override
	public void visit(Node node)
	{
	}
}
