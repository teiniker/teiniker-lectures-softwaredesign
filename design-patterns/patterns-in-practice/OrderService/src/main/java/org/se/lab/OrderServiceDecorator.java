package org.se.lab;

abstract class OrderServiceDecorator
	implements OrderService
{
	// Reference to the interface type
	private OrderService service;
	
	public OrderServiceDecorator(OrderService service)
	{
		if(service == null)
			throw new IllegalArgumentException();
		this.service = service;
	}
	
	public long placeOrder(Order order)
	{
		return service.placeOrder(order);
	}
}
