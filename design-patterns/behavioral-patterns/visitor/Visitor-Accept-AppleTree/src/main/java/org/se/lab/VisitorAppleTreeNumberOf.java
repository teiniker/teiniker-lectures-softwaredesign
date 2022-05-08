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
		// nothing to do
	}
	
	public void visit(Leaf leaf)
	{
		numberOfLeafs++;
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
