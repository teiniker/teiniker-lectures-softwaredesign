package org.se.lab;

public abstract class FileSystemVisitor
{
    public void visit(Node node)
    {
        switch (node)
        {
            case File f     -> visit(f);
            case Directory d-> visit(d);
            default         -> throw new IllegalArgumentException("Unknown node type");
        }
    }	
	public abstract void visit(File file);
	public abstract void visit(Directory dir);
}
