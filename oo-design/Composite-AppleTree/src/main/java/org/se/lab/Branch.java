package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Node
{
	/*
	 * Composite operations
	 */
	
	public int numberOfLeafs()
	{
		int number = 0;
		for(Node n : getNodes())
		{
			number += n.numberOfLeafs();
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
			throw new NullPointerException();
		nodes.add(node);
	}	
	@Override
	public List<Node> getNodes()
	{
		return nodes;
	}
}
