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
	 * Composite operations
	 */
	public abstract int numberOfLeafs();
	public abstract int numberOfRedApples();
	public abstract int numberOfGreenApples();
}
