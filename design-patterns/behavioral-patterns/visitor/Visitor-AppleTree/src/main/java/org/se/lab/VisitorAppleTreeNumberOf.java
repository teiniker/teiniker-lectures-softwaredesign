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
		// operation
		numberOfGreenApples++;

		// navigation
	}
	
	public void visit(RedApple apple)
	{
		// operation
		numberOfRedApples++;

		// navigation
	}
}
