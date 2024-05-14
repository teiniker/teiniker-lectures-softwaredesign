package org.se.lab;

import org.junit.Before;
import org.junit.Test;

public class CustomAssertOrderTest
{
	private Order order;
	
	@Before
	public void setup()
	{
	    // actual Order (result of an exercise)
		order = new Order(1, "Special order");
		order.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
		order.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));		
	}
	
	
	@Test
	public void testOrder()
	{
		// verify
	    Order expected = createExpectedOrder();
	    CustomAssert.assertEquals(expected, order);
	}
		
	
	public Order createExpectedOrder()
	{
	    Order expected = new Order(1, "Special order");
	    expected.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
	    expected.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));
	    return order;
	}
}
