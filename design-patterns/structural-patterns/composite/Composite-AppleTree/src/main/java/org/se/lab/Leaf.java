package org.se.lab;

public class Leaf extends Node
{
	/*
	 * Composite operations
	 */
	public int numberOfLeaves()
	{
		return 1;
	}
	
	public int numberOfRedApples()
	{
		return 0;
	}
	
	public int numberOfGreenApples()
	{
		return 0;
	}
}
