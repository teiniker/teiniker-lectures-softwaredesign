package org.se.lab;

public class DiscountOrderVisitor
	implements OrderVisitor
{
	private int discount;
	
	public DiscountOrderVisitor(int discount)
	{
		this.discount = discount;
	}
	
	@Override
	public void visit(Order order)
	{
		for(OrderLine line : order.getLines())
		{
			visit(line);
		}
	}

	@Override
	public void visit(OrderLine line)
	{
		visit(line.getProduct());
	}

	@Override
	public void visit(Product product)
	{
		long discountPrice = product.getPrice() * (100 - discount) / 100;
		product.setPrice(discountPrice);
	}	
}
