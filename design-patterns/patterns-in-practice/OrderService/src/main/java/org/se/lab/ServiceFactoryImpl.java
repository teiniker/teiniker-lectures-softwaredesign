package org.se.lab;

import org.se.lab.legacy.OrderProcessor;

class ServiceFactoryImpl
	implements ServiceFactory
{
	@Override
	public OrderService createOrderService()
	{
		return new OrderServiceLoggingDecorator(new OrderServiceAdapter(new OrderProcessor()));
	}
}
