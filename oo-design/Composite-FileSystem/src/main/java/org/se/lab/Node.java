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

	public abstract String getName(); 
	public abstract int numberOfFiles();
	public abstract long getSize(); 
}
