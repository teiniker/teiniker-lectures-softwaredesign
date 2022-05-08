package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorImplSlowTest
{
	private Calculator calc;
	
	@Before
	public void setup()
	{
		calc = new CalculatorImplSlow();
	}
	
	@Test
	public void testSumOfSequence()
	{
		// Exercise
		int result = calc.sumOfSequence(5);
		
		// Verify
		Assert.assertEquals(1+2+3+4+5, result);
	}
}
