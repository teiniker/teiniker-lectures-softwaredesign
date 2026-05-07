package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Location 
{
    /*
     * Constructor
     */
	public Location() 
	{
	}

	public void accept(Visitor visitor)
	{
		visitor.visit(this);
		for (ProductBundle bundle : getProducts())
		{
			bundle.accept(visitor);
		}
	}

	/*
	 * Association: --[*]-> products:Product
	 */
	private List<ProductBundle> products = new ArrayList<ProductBundle>();
	public List<ProductBundle> getProducts() 
	{
		return products;
	}
	public void addProduct(ProductBundle product) 
	{
		if(product==null)
			throw new IllegalArgumentException("Product is null!");
		
		this.products.add(product);
	}
}
