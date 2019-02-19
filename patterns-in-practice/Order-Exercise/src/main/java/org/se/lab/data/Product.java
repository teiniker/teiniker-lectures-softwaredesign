package org.se.lab.data;

public class Product extends Entity
{
    /*
     * Constructor
     */
	public Product(int id, String description, long price)
	{
		setId(id);
		setDescription(description);
		setPrice(price);
	}

	public Product(String description, long price)
	{
	    this(IntegerSequence.nextValue(), description, price);
	}
	
	/*
	 * Property: description:String
	 */
	private String description;
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
	    if(description == null)
	        throw new IllegalArgumentException("Invalid description!");
		this.description=description;
	}
	
	/*
	 * Property: price:long
	 */
	private long price;
	public long getPrice()
	{
		return this.price;
	}
	public void setPrice(long price)
	{
	    if(price < 0)
	        throw new IllegalArgumentException("Invalid price!");
		this.price = price;
	}
}
