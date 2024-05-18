package org.se.lab.data;

public class OrderLine extends Entity
{
	/*
	 * Constructor
	 */
    
	public OrderLine(int id, long quantity, Product product)
	{
		setId(id);
		setProduct(product);
		setQuantity(quantity);
	}
	
	public OrderLine(long quantity, Product product)
    {
	    this(IntegerSequence.nextValue(), quantity, product);
    }
	
	
	/*
	 * Property: quantity:long
	 */
	private long quantity;
	public long getQuantity()
	{
		return this.quantity;
	}
	public void setQuantity(long quantity)
	{
	    if(quantity < 0)
	        throw new IllegalArgumentException("Invalid quantity!");
		this.quantity = quantity;
	}
	
	
	/*
	 * Association: ---[1]-> product:Product
	 */
	private Product product;
	public Product getProduct()
	{
		return this.product;
	}
	public void setProduct(Product product)
	{
	    if(product == null)
	        throw new IllegalArgumentException("Invalid Product!");
	    this.product = product;
	}
}
