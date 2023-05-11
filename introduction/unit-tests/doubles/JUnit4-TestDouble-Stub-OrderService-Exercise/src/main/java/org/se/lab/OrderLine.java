package org.se.lab;

public class OrderLine
	extends Entity
{
	/*
	 * Constructor
	 */
	public OrderLine(int id, int quantity, Product product)
	{
		setId(id);
		setQuantity(quantity);
		setProduct(product);
	}
	
	
	/*
	 * Property: quantity
	 */
	private int quantity;
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
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
		this.product = product;
	}

	
	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return getId() + "," + getQuantity() + "," + getProduct();
	}
}
