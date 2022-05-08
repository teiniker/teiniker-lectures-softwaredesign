package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Branch 
	extends Node
{	
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
	
	@Override
	public void accept(VisitorAppleTree v)
	{
		v.visit(this);
		
		for(Node n : nodes)
		{
			n.accept(v);
		}
	}
}
