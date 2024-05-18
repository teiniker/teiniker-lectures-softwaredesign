package org.se.lab.service;

import org.se.lab.data.DiscountCommand;
import org.se.lab.data.Order;

public class RegularShippingHandler 
    extends ShippingHandler
{
    private final Logger LOG = Logger.getInstance();
    
    @Override
	public void handleShippingType(Order order, DiscountCommand cmd)
	{
	    long price = cmd.discountPrice(order);
	    LOG.debug("RegularShippingHandler: price=" + price);
	}
}
