package org.se.lab;

public class OrderLine
	extends Entity
{
	/*
	 * Constructor
	 */
	public OrderLine(long id, int quantity, Product product)
	{
		setId(id);
		setQuantity(quantity);
		setProduct(product);
	}
	

	/*
	 * Property: quantity:int
	 */
	private int quantity;
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		if(quantity < 0)
			throw new IllegalArgumentException();
		this.quantity = quantity;
	}
	
		
	/*
	 * Association: ---[1]-> Product
	 */
	private Product product;
	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product product)
	{
		if(product == null)
			throw new IllegalArgumentException();
		this.product = product;
	}

	
	/*
	 * Object methods
	 */
	
	public String toString()
	{
		return getId() + "," + getQuantity() + "," + getProduct().getId();
	}
}
