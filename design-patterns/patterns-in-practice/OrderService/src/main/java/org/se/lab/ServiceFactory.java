package org.se.lab;

public interface ServiceFactory
{
	ServiceFactory INSTANCE = new ServiceFactoryImpl();
	
	OrderService createOrderService();
}
