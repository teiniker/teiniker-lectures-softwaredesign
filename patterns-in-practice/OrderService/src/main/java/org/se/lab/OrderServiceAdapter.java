package org.se.lab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.se.lab.legacy.OrderProcessor;
import org.se.lab.legacy.OrderRecord;

class OrderServiceAdapter
	implements OrderService
{
	// Reference to the legacy class
	private OrderProcessor processor;
	
	public OrderServiceAdapter(OrderProcessor processor)
	{
		if(processor == null)
			throw new IllegalArgumentException();
		this.processor = processor;
	}
	
	@Override
	public long placeOrder(Order order) 
	{
		long totalPrice;
		try
		{
			totalPrice = processor.process(toOrderRecordTable(order));
			return totalPrice;
		} 
		catch (SQLException e)
		{			
			throw new ServiceException("Can't place Order!", e);
		}
	}

	
	private OrderRecord toOrderRecord(OrderLine line)
	{
		OrderRecord record = new OrderRecord();
		record.id = line.getId();
		record.quantity = line.getQuantity();
		record.description = line.getProduct().getDescription();
		record.price = line.getProduct().getPrice();
		return record;
	}
	
	private List<OrderRecord> toOrderRecordTable(Order order)
	{
		List<OrderRecord> table = new ArrayList<>();
		for(OrderLine line : order.getLines())
		{
			table.add(toOrderRecord(line));
		}
		return table;
	}
}
