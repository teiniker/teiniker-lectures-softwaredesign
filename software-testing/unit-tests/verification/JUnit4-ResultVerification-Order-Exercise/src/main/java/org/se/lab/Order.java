package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Order
	extends Entity
{
	/*
	 * Constructor
	 */
	public Order(long id, String name)
	{
		setId(id);
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
			throw new IllegalArgumentException();
		this.name = name;
	}
	
	
	/*
	 * Association: ---[*]-> lines:Order
	 */
	private List<OrderLine> lines = new ArrayList<>();
	public void addOrderLine(OrderLine line)
	{
		if(line == null)
			throw new IllegalArgumentException();
		lines.add(line);
	}
	public List<OrderLine> getOrderLines()
	{
		return lines;
	}
}
