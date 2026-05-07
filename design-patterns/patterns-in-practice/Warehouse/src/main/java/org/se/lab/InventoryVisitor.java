package org.se.lab;

import java.util.HashMap;
import java.util.Map;

public class InventoryVisitor 
    implements Visitor
{
	private Map<String, Integer> inventoryList = new HashMap<String, Integer>();
	public Map<String, Integer> getInventoryList()
	{
		return inventoryList;
	}

	
	/*
	 * Visit methods
	 */
	
	public void visit(Warehouse warehouse)
	{
	    // Process
	    // Navigation
	}
	
	public void visit(Area area)
	{
        // Process
        // Navigation
	}
	
	
	public void visit(Location location)
	{
        // Process
        // Navigation
	}
	
	public void visit(ProductBundle product)
	{
       // Process
		String productId = product.getId();
		int quantity = product.getQuantity();  
				
		if (inventoryList.containsKey(productId))
		{
			quantity += inventoryList.get(productId);
		}
		inventoryList.put(productId, quantity);

		// Navigation
	}
}
