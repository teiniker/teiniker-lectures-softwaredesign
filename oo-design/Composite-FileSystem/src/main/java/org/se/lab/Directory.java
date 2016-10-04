package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Directory 
	extends Node
{
	/*
	 * Constructor
	 */
	public Directory(String name)
	{
		setName(name);
	}
	
	
	/*
	 * Property: name:String
	 */
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		if(name == null)
			throw new NullPointerException();
		this.name = name;
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
	
	
	/*
	 *  Operations
	 */
	
	@Override
	public long getSize()
	{
		long size = 0;
		for(Node n : getNodes())
		{
			size += n.getSize();
		}
		return size;
	}
	
	@Override
	public int numberOfFiles()
	{
		int number = 0;
		for(Node n : getNodes())
		{
			number += n.numberOfFiles();
		}
		return number;
	}
}
