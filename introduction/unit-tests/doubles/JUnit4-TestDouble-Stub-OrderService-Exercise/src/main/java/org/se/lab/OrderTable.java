package org.se.lab;

import java.util.List;

public interface OrderTable
{
	void insertOrder(Order order);
	void deleteOrder(int id);

	List<Order> findAllOrders();
	Order findOrderById(int id);
}