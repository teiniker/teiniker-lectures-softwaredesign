package org.se.lab;

public class OrderLine extends Entity
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
	 * Property: quantity:int
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
	 * Association: --[1]-> product:Product
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
		return "OrderLine [id=" + id + ", quantity=" + quantity + ", product=" + product + "]";
	}	
	
}
