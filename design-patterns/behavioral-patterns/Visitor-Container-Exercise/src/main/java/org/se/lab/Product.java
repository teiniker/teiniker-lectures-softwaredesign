package org.se.lab;

public class Product
	extends Component
{
	/*
	 * Constructor
	 */
	public Product(String name, int weight, long price)
	{
		setName(name);
		setWeight(weight);
		setPrice(price);
	}
		
		
	/*
	 * Property: weight:int
	 */
	private int weight;
	public final int getWeight()
	{
		return weight;
	}
	public final void setWeight(int weight)
	{
		this.weight = weight;
	}
		
	
	/*
	 * Property: price:long
	 */
	private long price;
	public final long getPrice()
	{
		return price;
	}
	public final void setPrice(long price)
	{
		this.price = price;
	}	
}
