package org.se.lab.data;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OrderVisitorTest 
{
	private Order order;
	
	@Before
	public void setup()
	{
	    IntegerSequence.setInitValue(1);
	    order = new Order(IntegerSequence.nextValue(), new GregorianCalendar(2016,06,18).getTime(), ShippingType.EXPRESS);
	    order.addOrderline(new OrderLine(IntegerSequence.nextValue(), 10, new Product(IntegerSequence.nextValue(), "Head First Design Patterns", 4900)));
	    order.addOrderline(new OrderLine(IntegerSequence.nextValue(), 5, new Product(IntegerSequence.nextValue(), "Patterns kompakt", 1499)));
	    order.addOrderline(new OrderLine(IntegerSequence.nextValue(), 7, new Product(IntegerSequence.nextValue(), "Design Patterns.", 4295)));
	}
	
	
	@Test
	public void testTotalPrice()
	{
	    TotalPriceVisitor visitor = new TotalPriceVisitor();
	    long totalPrice = visitor.visit(order);
	    long expectedPrice = 10*4900 + 5*1499 + 7*4295; 
	    Assert.assertEquals(expectedPrice, totalPrice);	    
	}
}
