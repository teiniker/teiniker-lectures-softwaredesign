package org.se.lab;

public class Product
	extends Entity
{
	/*
	 * Constructors
	 */
	public Product(int id, String title, long price)
	{
		super(id);
		setTitle(title);
		setPrice(price);
	}

	public Product(String title, long price)
	{
		super(IntegerSequence.getNextValue());
		setTitle(title);
		setPrice(price);
	}


	/*
	 * Property: title:String
	 */
	private String title;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		if(title == null)
			throw new IllegalArgumentException("Title is null");

		this.title = title;
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
			throw new IllegalArgumentException("price < 0");

		this.price = price;
	}


	/*
	 * Association: ---[1]-> category:Category
	 */
	private Category category;
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		if(category == null)
			throw new IllegalArgumentException("Category is null!");

		this.category = category;
	}



	/*
	 * Operations
	 */

	public String toXml()
	{
		return "<product id=\"" + getId() 
			+ "\" title=\"" + getTitle() + "\" price=\""
			+ getPrice()/100.0 + "\"/>";
	}
}
