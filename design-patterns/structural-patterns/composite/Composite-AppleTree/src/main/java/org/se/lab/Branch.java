package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Node
{
	/*
	 * Composite operations
	 */
	
	public int numberOfLeaves()
	{
		int number = 0;
		for(Node n : getNodes())
		{
			number += n.numberOfLeaves();
		}
		return number;
	}
	
	public int numberOfRedApples()
	{
		int number = 0;
		for(Node n : getNodes())
		{
			number += n.numberOfRedApples();
		}
		return number;
	}
	
	public int numberOfGreenApples()
	{
		int number = 0;
		for(Node n : getNodes())
		{
			number += n.numberOfGreenApples();
		}
		return number;
	}
	
	
	/*
	 * Navigation
	 */
	private List<Node> nodes = new ArrayList<Node>();
	@Override
	public void addNode(Node node)
	{
		if(node == null)
			throw new IllegalArgumentException();
		nodes.add(node);
	}	
	@Override
	public List<Node> getNodes()
	{
		return nodes;
	}
}
