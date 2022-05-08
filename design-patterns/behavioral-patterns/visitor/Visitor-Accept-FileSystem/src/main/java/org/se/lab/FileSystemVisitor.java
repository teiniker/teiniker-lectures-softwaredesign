package org.se.lab;

public interface FileSystemVisitor
{
	void visit(Node node);
	void visit(File file);
	void visit(Directory dir);
}
