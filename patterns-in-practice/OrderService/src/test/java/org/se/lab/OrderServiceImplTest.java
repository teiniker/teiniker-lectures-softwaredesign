package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceImplTest
{
	private OrderService service;
	private Order order;
	private final Logger LOG = Logger.getInstance();
	
	@Before
	public void setup()
	{
		LOG.getLogList().clear();
		service = ServiceFactory.INSTANCE.createOrderService();
		order = new OrderBuilder().id(7).lines(
				new OrderLineBuilder().id(1).quantity(5).product(123, "Java Book", 3990).toOrderLine(),
				new OrderLineBuilder().id(2).quantity(2).product(232, "GoF Book", 4190).toOrderLine(),
				new OrderLineBuilder().id(3).quantity(7).product(666, "Guinness", 250).toOrderLine())
				.toOrder();
	}
	
	
	@Test
	public void testCaluclateTotalCosts()
	{
		long totalCosts = service.placeOrder(order);
		
		Assert.assertEquals(5*3990 + 2*4190 + 7*250, totalCosts);
		// You can change the value to "Order: 7 => EUR 300,80"
		Assert.assertTrue("", LOG.getLogList().get(0).contains("Order: 7 => EUR 300.80"));
	}
	
	
	@Test
	public void testCaluclateOrderDiscount()
	{
		DiscountOrderVisitor visitor = new DiscountOrderVisitor(10); // 10% discount for every product
		visitor.visit(order);

		long totalCosts = service.placeOrder(order);
		
		Assert.assertEquals((5*3990 + 2*4190 + 7*250)*(100-10)/100, totalCosts);		
	}
}
