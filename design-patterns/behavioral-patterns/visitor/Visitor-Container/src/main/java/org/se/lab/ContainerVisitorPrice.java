package org.se.lab;

public class ContainerVisitorPrice
	extends AbstractContainerVisitor
{
	private long price = 0;
	public long getPrice()
	{
		return price;
	}
		
	@Override
	public void visit(Product product)
	{
		// calculate
		price += product.getPrice();

		// navigation
	}
}
