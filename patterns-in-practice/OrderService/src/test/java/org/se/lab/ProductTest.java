package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class ProductTest
{
	@Test
	public void testToString()
	{
		Product p = new Product(7, "Effective Java: A Programming Language Guide", 3695);
		
		Assert.assertEquals("7,Effective Java: A Programming Language Guide,36.95", p.toString());
	}
	
	
}
