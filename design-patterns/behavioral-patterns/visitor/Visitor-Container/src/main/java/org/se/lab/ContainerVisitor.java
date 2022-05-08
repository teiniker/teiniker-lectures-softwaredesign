package org.se.lab;

public interface ContainerVisitor
{
	void visit(Product product);
	
	void visit(Container container);
	
	void visit(Component component);
}
