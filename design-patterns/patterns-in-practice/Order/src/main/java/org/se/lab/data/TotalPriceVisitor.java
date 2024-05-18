package org.se.lab.data;

public class TotalPriceVisitor
    implements OrderVisitor
{
	public long visit(Order order)
	{	    
	    long totalPrice = 0;
		for(OrderLine o : order.getOrderlines())
		{
			totalPrice += visit(o);
		}
		return totalPrice;
	}
	
	
	public long visit(OrderLine orderline)
	{
	    long productPrice = visit(orderline.getProduct());
	    return orderline.getQuantity() * productPrice;
	}
	
		
	public long visit(Product product)
	{
		return product.getPrice();
	}	
}
