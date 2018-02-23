package org.se.lab;

import java.util.List;

public interface Node
{
	default void addNode(Node node)
	{
		throw new UnsupportedOperationException();
	}
	
	default List<Node> getNodes()
	{
		throw new UnsupportedOperationException();
	}

	public abstract String getName(); 
	public abstract int numberOfFiles();
	public abstract long numberOfBytes();
}
