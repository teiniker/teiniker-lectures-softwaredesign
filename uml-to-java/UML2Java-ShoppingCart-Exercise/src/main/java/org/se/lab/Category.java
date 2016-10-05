package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Category
	extends Entity
{
	/*
	 * Constructors
	 */
	public Category(String name)
	{
		super(IntegerSequence.getNextValue());
		setName(name);
	}


	/*
	 * Property: name:String
	 */
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		if(name == null)
			throw new IllegalArgumentException("Name is null!");

		this.name = name;
	}


	/*
	 * Association: ---[*]-> products:Product
	 */
	private List<Product> products = new ArrayList<Product>();
	public void addProduct(Product p)
	{
		if(p == null)
			throw new IllegalArgumentException("Product is null!");

		products.add(p);
	}
	public List<Product> getProducts()
	{
		return products;
	}

	
	/*
	 * Association: ---[*]-> children:Category
	 */
	private List<Category> children = new ArrayList<Category>();
	public void addChild(Category c)
	{
		if(c == null)
			throw new IllegalArgumentException("Child category is null!");
		
		children.add(c);
	}
	public List<Category> getChildren()
	{
		return children;
	}
	
	
	/*
	 * Association: ---[1]-> parent:Category
	 */
	private Category parent;
	public Category getParent()
	{
		return parent;
	}
	public void setParent(Category parent)
	{
		if(parent == null)
			throw new IllegalArgumentException("Parent category is null!");
		
		this.parent = parent;
	}
	
	
	/*
	 * Operations
	 */
	
	public String toXml()
	{
		StringBuilder xml = new StringBuilder();
		
		xml.append("<category id=\"").append(getId());
		xml.append("\" name=\"").append(getName());
		xml.append("\">\n");
		for(Product p : getProducts())
		{
			xml.append(p.toXml()).append("\n");
		}
		for(Category c : getChildren())
		{
			xml.append(c.toXml()).append("\n");
		}
		xml.append("</category>");
		return xml.toString();
	}
}
