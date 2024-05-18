package org.se.lab.service;

import org.se.lab.data.DiscountCommand;
import org.se.lab.data.Order;
import org.se.lab.data.ShippingType;

public class ExpressShippingHandler 
    extends ShippingHandler
{
    private final Logger LOG = Logger.getInstance();
    
    @Override
	public void handleShippingType(Order order, DiscountCommand cmd)
	{
	    
		if(order.getShippingType() == ShippingType.EXPRESS)
		{
		    long price = cmd.discountPrice(order);
		    LOG.debug("ExpressShippingHandler: price=" + price);
		}
		else
		{
		    LOG.debug("forward");
			super.handleShippingType(order, cmd);
		}
	}
}
