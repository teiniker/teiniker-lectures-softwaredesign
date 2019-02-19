package org.se.lab;

public class ContainerVisitorWeight
	extends AbstractContainerVisitor
{
	private long weight = 0;
	public long getWeight()
	{
		return weight;
	}
		
	@Override
	public void visit(Product product)
	{
		weight += product.getWeight();
	}
}
