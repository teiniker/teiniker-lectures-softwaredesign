package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class ContainerVisitorWeightTest 
	extends AbstractContainerTest
{
	@Test
	public void testTotalWeight()
	{
		ContainerVisitorWeight visitor = new ContainerVisitorWeight();
		visitor.visit(component);
		Assert.assertEquals(200+150+500+12000, visitor.getWeight());
	}
}
