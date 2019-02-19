package org.se.lab;

public class VisitorAppleTreeNumberOf
	implements VisitorAppleTree
{
	private int numberOfLeafs = 0;
	private int numberOfRedApples = 0;
	private int numberOfGreenApples = 0;
	
	public int getNumberOfLeafs()
	{
		return numberOfLeafs;
	}

	public int getNumberOfRedApples()
	{
		return numberOfRedApples;
	}

	public int getNumberOfGreenApples()
	{
		return numberOfGreenApples;
	}

	
	/*
	 * Visit methods
	 */
	
	public void visit(Node node)
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
	
	public void visit(Branch branch)
	{
		// operation
		
		// navigation
		for(Node n : branch.getNodes())
		{
			visit(n);
		}
	}
	
	public void visit(Leaf leaf)
	{
		// operation
		numberOfLeafs++;
		
		// navigation
	}
	
	public void visit(GreenApple apple)
	{
		numberOfGreenApples++;
	}
	
	public void visit(RedApple apple)
	{
		numberOfRedApples++;
	}
}
