package org.se.lab;

import org.junit.Before;
import org.junit.Test;

public class CustomAssertWithBuilderOrderTest
{
	private Order order;
	
	@Before
	public void setup()
	{
		// SUT
		order = new Order(1, "Special order");
		order.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
		order.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));		
	}
	
	
	@Test
	public void testOrder()
	{
		Order expected = new OrderBuilder().id(1).name("Special order")
				.line().id(2).quantity(1).product().id(3).description("Pizza Frutti di Mare").price(880)
				.line().id(4).quantity(2).product().id(5).description("Pizza Quattro Formaggi").price(820)
				.build();

	    CustomAssert.assertEquals(expected, order);
	}

}
