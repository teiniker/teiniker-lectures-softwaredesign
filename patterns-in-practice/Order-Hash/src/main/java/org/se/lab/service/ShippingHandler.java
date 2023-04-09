package org.se.lab.service;

import org.se.lab.data.DiscountCommand;
import org.se.lab.data.Order;

public abstract class ShippingHandler 
{
	/*
	 * Reference to next ShippingHandler
	 */
	private ShippingHandler successor;
	public ShippingHandler getSuccessor() 
	{
		return successor;
	}
	public void setSuccessor(ShippingHandler successor) 
	{
		this.successor = successor;
	}
	

	/*
	 * Default Handler Implementation
	 */
	public void handleShippingType(Order order, DiscountCommand cmd)
	{
		if (getSuccessor() != null)
		{
			getSuccessor().handleShippingType(order, cmd);
		}
		else
		{
			throw new IllegalArgumentException("No valid handler found!");
		}
	}
	
}
