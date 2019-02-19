package org.se.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Builder Pattern
 * 
 * The Director is implicit part or the test setup. 
 * Builder interface and ConcreteBuilder are merged into a single OrderBuilder class.
 * As final product we build an Order object containing the parts id, and many lines.
 *
 * Note that we can use another Builder to create OrderLine objects.
 */

public class OrderBuilder
{
	private int id;
	private List<OrderLine> lines = new ArrayList<OrderLine>();
	
	public OrderBuilder id(int id)
	{
		this.id = id;
		return this;
	}
	
	
	public OrderBuilder lines(OrderLine... lines)
	{
		this.lines = Arrays.asList(lines);
		return this;
	}
	
	public Order toOrder()
	{
		Order order = new Order(id);
		order.setLines(lines);
		return order;
	}
}
