package org.se.lab;

public interface OrderVisitor
{
	void visit(Order order);
	void visit(OrderLine line);
	void visit(Product product);
}
