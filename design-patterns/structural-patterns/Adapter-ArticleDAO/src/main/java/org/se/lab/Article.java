package org.se.lab;

/*
 * 3 Punkte
 */

public class Article
{
	/*
	 * Constructor
	 */
	public Article(int id, String description, long price)
	{
		setId(id);
		setDescription(description);
		setPrice(price);
	}
	
	
	/*
	 * Property: id:int
	 */
	protected int id;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
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
		this.price = price;
	}
	
	/*
	 * Object methods
	 */

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	@Override
	public String toString()
	{
		return getId() + "," + getDescription() + "," + String.format("%5.2f", getPrice()/100.0);
	}
}
