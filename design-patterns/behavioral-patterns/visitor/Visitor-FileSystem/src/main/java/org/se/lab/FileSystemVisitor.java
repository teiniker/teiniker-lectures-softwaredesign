package org.se.lab;

public abstract class FileSystemVisitor
{
	public void visit(Node node)
	{
		if(node instanceof File)
		{	
			visit((File)node);
		}
		else if(node instanceof Directory)
		{
			visit((Directory)node);
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	public abstract void visit(File file);
	public abstract void visit(Directory dir);
}
