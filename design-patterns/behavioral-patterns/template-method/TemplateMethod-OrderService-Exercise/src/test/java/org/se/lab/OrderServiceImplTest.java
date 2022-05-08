package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceImplTest
{
	private OrderService service;
	
	@Before
	public void setup()
	{
		service = new OrderServiceImpl();
	}
	
	
	@Test
	public void testCaluclateTotalCosts()
	{
		Order order = new OrderBuilder().id(7).lines(
				new OrderLineBuilder().id(1).quantity(5).product(123, "Java Book", 3990).toOrderLine(),
				new OrderLineBuilder().id(2).quantity(2).product(232, "GoF Book", 4190).toOrderLine(),
				new OrderLineBuilder().id(3).quantity(7).product(666, "Guinness", 250).toOrderLine())
				.toOrder();
		
		long totalCosts = service.caluclateTotalCosts(order);
		
		Assert.assertEquals(32063, totalCosts);
	}
	
}
