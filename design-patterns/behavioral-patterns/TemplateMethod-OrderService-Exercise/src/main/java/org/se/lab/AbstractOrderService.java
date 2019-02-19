package org.se.lab;


public abstract class AbstractOrderService
	implements OrderService
{
	
	@Override
	public final long caluclateTotalCosts(Order order)
	{
		long totalCosts = 0;
		
		for(OrderLine line : order.getLines())
		{
			long price = line.getProduct().getPrice();
			int quantity = line.getQuantity();	
			
			long discount = price * getDiscount(line) / 100;
			long netto = price - discount;
			long tax = netto * getTaxRate(line.getProduct())/100;
			long brutto = netto + tax;
			totalCosts += brutto * quantity;
		}
		return totalCosts;
	}

	protected abstract int getTaxRate(Product product);
	protected abstract int getDiscount(OrderLine line);
}
