package org.se.lab;

public abstract class FileSystemVisitor
{
	public void visit(Node node)
	{
		if(node instanceof File)
		{
			File f = (File)node;
			visit(f);
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
