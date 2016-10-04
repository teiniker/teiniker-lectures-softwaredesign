package org.se.lab.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.Calculator;
import org.se.lab.CalculatorFactory;
import org.se.lab.TimeComplexity;


public class StrategyTest
{
	@Before
	public void setup()
	{
//		The following operations should not work!
//		new CalculatorImplFast(); 
//		new CalculatorImplSlow();
//		new Factory();
	}
	
	@Test
	public void testSingleton()
	{
		CalculatorFactory f1 = CalculatorFactory.getInstance();
		CalculatorFactory f2 = CalculatorFactory.getInstance();
		Assert.assertNotNull(f1);
		Assert.assertNotNull(f2);
		Assert.assertTrue(f1 == f2);
	}
	
	@Test
	public void testSlowImpl()
	{
		Calculator calc = CalculatorFactory.getInstance().createCalculator(TimeComplexity.LINEAR);
		int result = calc.sumOfSequence(5);
		Assert.assertEquals(15, result);
	}

	@Test
	public void testFastImpl()
	{
		Calculator calc = CalculatorFactory.getInstance().createCalculator(TimeComplexity.CONSTANT);
		int result = calc.sumOfSequence(5);
		Assert.assertEquals(15, result);
	}
}
