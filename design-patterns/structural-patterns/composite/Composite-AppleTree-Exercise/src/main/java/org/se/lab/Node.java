package org.se.lab;

import java.util.List;

public abstract class Node
{
	public void addNode(Node node)
	{
		throw new UnsupportedOperationException();
	}
	
	public List<Node> getNodes()
	{
		throw new UnsupportedOperationException();
	}
	
	/*
	 * Composite API operations
	 */
	public abstract int numberOfLeaves();
	public abstract int numberOfRedApples();
	public abstract int numberOfGreenApples();
}
