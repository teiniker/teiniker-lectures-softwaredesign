package org.se.lab;

public class ProductBundle 
{
    /*
     * Constructor
     */
	public ProductBundle(String id, int quantity) 
	{
	    setId(id);
		setQuantity(quantity);
	}

	/*
	 * Property: id:String
	 */
	private String id;
	public String getId() 
	{
		return id;
	}
	public void setId(String id) 
	{
		if (id == null || id.length() == 0)
			throw new IllegalArgumentException("Product ID is null!");
		
		this.id = id;
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
}
