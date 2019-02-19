package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class ContainerVisitorPriceTest 
	extends AbstractContainerTest
{
	@Test
	public void testTotalPrice()
	{
		ContainerVisitorPrice visitor = new ContainerVisitorPrice();
		visitor.visit(component);
		Assert.assertEquals(1990+1390+3980+99990, visitor.getPrice());
	}
}
