package org.se.lab;

public class OrderServiceImpl
	extends AbstractOrderService
{

	@Override
	protected int getTaxRate(Product product)
	{
		if(product.getDescription().contains("Book"))
		{
			return 10; // in %
		}
		else
		{
			return 20; // in %
		}
	}

	@Override
	protected int getDiscount(OrderLine line)
	{	
		if(line.getQuantity() >= 5)
		{
			return 5; // in %
		}
		else
		{
			return 0; // in % 
		}
	}

}
