package org.se.lab;

public interface VisitorAppleTree
{
	void visit(Node node);
	void visit(Branch branch);
	void visit(Leaf leaf);
	void visit(GreenApple apple);
	void visit(RedApple apple);
}
