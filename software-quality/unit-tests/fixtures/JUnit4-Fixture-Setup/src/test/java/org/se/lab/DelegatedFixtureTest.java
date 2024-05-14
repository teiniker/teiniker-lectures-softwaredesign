package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class DelegatedFixtureTest
{
	// Creation methods

	private Order createNewOrder()
	{
		Order order = new Order(1, "Special order");
		order.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
		order.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));
		return order;
	}


	@Test
	public void testOrder()
	{
		// setup
		Order order = createNewOrder();

		// exercise
		long id = order.getId();
		String name = order.getName();
		int numberOfLines = order.getOrderLines().size();

		// verify
		Assert.assertEquals(1, id);
		Assert.assertEquals("Special order", name);
		Assert.assertEquals(2, numberOfLines);

		// teardown
	}

	
	@Test
	public void testOrderLine1()
	{
		// setup
		Order order = createNewOrder();

        // exercise
		OrderLine line = order.getOrderLines().get(0);
		long id = line.getId();
        int quantity = line.getQuantity();
        Product product = line.getProduct();

        // verify
		Assert.assertEquals(2, id);
		Assert.assertEquals(1, quantity);
		Assert.assertNotNull(product);

		// teardown
	}

	
	@Test
	public void testOrderLine2()
	{
		// setup
		Order order = createNewOrder();

        // exercise
        OrderLine line = order.getOrderLines().get(1);
        long id = line.getId();
        int quantity = line.getQuantity();
        Product product = line.getProduct();

        // verify
		Assert.assertEquals(4, id);
		Assert.assertEquals(2, quantity);
		Assert.assertNotNull(product);

		// teardown
	}
}
