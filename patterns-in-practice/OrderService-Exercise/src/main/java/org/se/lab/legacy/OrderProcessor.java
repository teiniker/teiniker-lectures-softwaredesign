package org.se.lab.legacy;

import java.sql.SQLException;
import java.util.List;

/*
 * This is a simulation of a legacy class - just for testing purposes.
 * !! Don't write programs in that way !! 
 */
public class OrderProcessor
{
	List<OrderRecord> table;
	
	public long process(List<OrderRecord> table)
		throws SQLException
	{
		this.table = table;
		
		long totalPrice = 0;
		for(OrderRecord record : table)
		{
			totalPrice += record.price * record.quantity;
		}
		return totalPrice;
	}
}
