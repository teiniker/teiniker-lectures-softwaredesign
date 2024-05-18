package org.se.lab;

public class OrderServiceLoggingDecorator
	extends OrderServiceDecorator
{
	private static final Logger LOG = Logger.getInstance();
	
	public OrderServiceLoggingDecorator(OrderService service)
	{
		super(service);
	}
	
	public long placeOrder(Order order)
	{
		int id = order.getId();
		long totalPrice = super.placeOrder(order);
		LOG.log("Order: " + id + " => EUR " + String.format("%4.2f", totalPrice/100.0));
		return totalPrice;
	}
}
