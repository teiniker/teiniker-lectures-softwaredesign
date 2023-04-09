package org.se.lab.service;

import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.data.IntegerSequence;
import org.se.lab.data.Order;
import org.se.lab.data.OrderLine;
import org.se.lab.data.Product;
import org.se.lab.data.ShippingDiscount;
import org.se.lab.data.ShippingType;
import org.se.lab.data.TotalPriceVisitor;

public class ShippingHandlerTest 
{
	private ShippingHandler handler;	
	private Order order;
	
	@Before
	public void setup()
	{
	    Logger.getInstance().emptyLogList();

	    order = new Order(IntegerSequence.nextValue(), new GregorianCalendar(2016,06,18).getTime(), ShippingType.REGULAR);
	    order.addOrderline(new OrderLine(IntegerSequence.nextValue(), 10, new Product(IntegerSequence.nextValue(), "Head First Design Patterns", 4900)));
	    order.addOrderline(new OrderLine(IntegerSequence.nextValue(), 5, new Product(IntegerSequence.nextValue(), "Patterns kompakt", 1499)));
	    order.addOrderline(new OrderLine(IntegerSequence.nextValue(), 7, new Product(IntegerSequence.nextValue(), "Design Patterns.", 4295)));
	    
	    handler = new ExpressShippingHandler();
	    handler.setSuccessor(new RegularShippingHandler());
	}
	
	
	@Test
	public void testExpressShipping()
	{
	    order.setShippingType(ShippingType.EXPRESS);
	    
	    handler.handleShippingType(order, new ShippingDiscount(new TotalPriceVisitor()));
	    
	    List<String> logs = Logger.getInstance().getLogList();	
	    long totalPrice = 10*4900 + 5*1499 + 7*4295;	    
	    Assert.assertEquals("[ExpressShippingHandler: price="+totalPrice+"]", logs.toString());
	}

    @Test
    public void testRegularShipping()
    {
        handler.handleShippingType(order, new ShippingDiscount(new TotalPriceVisitor()));
        
        List<String> logs = Logger.getInstance().getLogList();      
        long totalPrice = 10*4900 + 5*1499 + 7*4295;        
        long expectedDiscountPrice = totalPrice - totalPrice * 5/100;
        Assert.assertEquals("[forward, RegularShippingHandler: price="+expectedDiscountPrice+"]", logs.toString());
    }
}
