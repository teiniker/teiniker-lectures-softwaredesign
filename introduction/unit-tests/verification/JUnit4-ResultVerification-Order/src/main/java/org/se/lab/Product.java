package org.se.lab;

public class Product
	extends Entity
{
	/*
	 * Constructor
	 */
	public Product(long id, String description, long price)
	{
		setId(id);
		setDescription(description);
		setPrice(price);
	}
		
	
	/*
	 * Property: description:String
	 */
	private String description;
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		if(description == null)
			throw new IllegalArgumentException();
		this.description = description;
	}
	
	
	/*
	 * Property: price:long
	 */
	private long price;
	public long getPrice()
	{
		return price;
	}
	public void setPrice(long price)
	{
		if(price < 0)
			throw new IllegalArgumentException();
		this.price = price;
	}
	
	
	/*
	 * Object methods
	 */
	@Override
	public String toString()
	{
		return getId() + "," + getDescription() + "," + getPrice();
	}	
}
