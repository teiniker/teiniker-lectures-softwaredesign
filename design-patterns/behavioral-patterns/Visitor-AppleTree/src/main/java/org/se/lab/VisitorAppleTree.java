package org.se.lab;

public interface VisitorAppleTree
{
	default void visit(Node node)
	{
		if(node instanceof Branch)
		{
			visit((Branch)node);
		}
		else if(node instanceof GreenApple)
		{
			visit((GreenApple)node);
		}
		else if(node instanceof RedApple)
		{
			visit((RedApple)node);
		}
		else if(node instanceof Leaf)
		{
			visit((Leaf)node);
		}
		else
		{
			throw new IllegalArgumentException("Unknown node type!");
		}
	}

	void visit(Branch branch);
	void visit(Leaf leaf);
	void visit(GreenApple apple);
	void visit(RedApple apple);
}
