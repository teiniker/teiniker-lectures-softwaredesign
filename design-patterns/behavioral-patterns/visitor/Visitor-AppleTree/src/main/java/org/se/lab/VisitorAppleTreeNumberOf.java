package org.se.lab;

public class VisitorAppleTreeNumberOf
	implements VisitorAppleTree
{
	private int numberOfLeaves = 0;
	private int numberOfRedApples = 0;
	private int numberOfGreenApples = 0;
	
	public int getNumberOfLeaves()
	{
		return numberOfLeaves;
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
		branch.getNodes().forEach(n -> visit(n));
	}
	
	public void visit(Leaf leaf)
	{
		// operation
		numberOfLeaves++;
		
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
