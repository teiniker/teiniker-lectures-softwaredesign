package org.se.lab;

import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Test;

public class PredicateTest
{
	@Test
	public void testTest()
	{
		Predicate<Integer> isPositive = (num) -> num > 0;

		Assert.assertTrue(isPositive.test(7));
	}

	@Test
	public void testNegate()
	{
		Predicate<Integer> isPositive = (num) -> num > 0;

		Assert.assertFalse(isPositive.negate().test(7));
	}

	@Test
	public void testAnd()
	{
		Predicate<Integer> isPositive = (num) -> num > 0;
		Predicate<Integer> isEven = (num) -> num % 2 == 0;

		Assert.assertTrue(isPositive.and(isEven).test(8));
	}

	@Test
	public void testOr()
	{
		Predicate<Integer> isPositive = (num) -> num > 0;
		Predicate<Integer> isEven = (num) -> num % 2 == 0;

		Assert.assertTrue(isPositive.or(isEven).test(7));
	}
}
