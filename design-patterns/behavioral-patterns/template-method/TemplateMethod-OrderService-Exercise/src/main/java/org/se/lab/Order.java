package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Order 
	extends Entity
{
	/*
	 * Constructor
	 */
	
	public Order(int id)
	{
		setId(id);
	}
	
	
	/*
	 * Association: ---[*]-> lines:OrderLine
	 */
	private List<OrderLine> lines = new ArrayList<OrderLine>();
	public List<OrderLine> getLines()
	{
		return lines;
	}
	public void setLines(List<OrderLine> lines)
	{
		this.lines = lines;
	}
	public void addOrderLine(OrderLine line)
	{
		lines.add(line);
	}
	
	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return "Order [id=" + id + ", lines=" + lines + "]";
	}
	
}
