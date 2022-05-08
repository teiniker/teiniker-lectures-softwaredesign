package org.se.lab;

/*
 * Builder Pattern
 * 
 * The Director is implicit part or the test setup. 
 * Builder interface and ConcreteBuilder are merged into a single OrderLineBuilder class.
 * As final product we build an OrderLine object containing the parts id, quantity and product.
 */

public class OrderLineBuilder
{
	private int id;
	private int quantity;
	private Product product;
	
	
	public OrderLineBuilder id(int id)
	{
		this.id = id;
		return this;
	}
	
	public OrderLineBuilder quantity(int quantity)
	{
		this.quantity = quantity;
		return this;
	}
	
	public OrderLineBuilder product(int id, String name, long price)
	{
		product = new Product(id, name, price);
		return this;
	}		

	public OrderLine toOrderLine()
	{
		return new OrderLine(id, quantity, product);
	}		
}

