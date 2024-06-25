package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class MyPredicateTest
{
	@Test
	public void testTest()
	{
		MyPredicate<Integer> isPositive = (num) -> {System.out.printf("test(): %d > 0 ", num); return num > 0;};
		Assert.assertTrue(isPositive.test(7));
	}

	@Test
	public void testNegate()
	{
		MyPredicate<Integer> isPositive = (num) -> {System.out.printf("test(): %d > 0 ", num); return num > 0;};

		Assert.assertFalse(isPositive.negate().test(7));
	}

	@Test
	public void testAnd()
	{
		MyPredicate<Integer> isPositive = (num) -> {System.out.printf("test(): %d > 0 ", num); return num > 0;};
		MyPredicate<Integer> isEven = (num) -> {System.out.printf("test(): %d %% 2 == 0 ", num); return num % 2 == 0;};

		boolean result = isPositive.and(isEven).test(8); // (8) -> 8 > 0 && 8 % 2 == 0
		Assert.assertTrue(result);
	}

	@Test
	public void testOr()
	{
		MyPredicate<Integer> isPositive = (num) -> {System.out.printf("test(): %d > 0 ", num); return num > 0;};
		MyPredicate<Integer> isEven = (num) -> {System.out.printf("test(): %d %% 2 == 0 ", num); return num % 2 == 0;};

		boolean result = isPositive.or(isEven).test(7); // (7) -> 7 > 0 || 7 % 2 == 0
		Assert.assertTrue(result);
	}

	@Test
	public void testAndOr()
	{
		MyPredicate<Integer> isPositive = (num) -> {System.out.printf("test(): %d > 0 ", num); return num > 0;};
		MyPredicate<Integer> isNegative = (num) -> {System.out.printf("test(): %d < 0 ", num); return num < 0;};
		MyPredicate<Integer> isEven = (num) -> {System.out.printf("test(): %d %% 2 == 0 ", num); return num % 2 == 0;};

		boolean result = isPositive.and(isEven).or(isNegative).and(isEven).test(4);
		// and: or: and: test(): 4 > 0 test(): 4 % 2 == 0 test(): 4 % 2 == 0 	=> true
		// and: or: and: test(): -4 > 0 test(): -4 < 0 test(): -4 % 2 == 0 		=> true
		// and: or: and: test(): 3 > 0 test(): 3 % 2 == 0 test(): 3 < 0 		=> false
		// and: or: and: test(): -3 > 0 test(): -3 < 0 test(): -3 % 2 == 0		=> false
		// Evaluation from left to right, expressions will be optimized: true || (something) is true,
		// 																 false && (something) is false

		Assert.assertTrue(result);
	}

	@Test
	public void testAndOr2()
	{
		MyPredicate<Integer> isPositive = (num) -> {System.out.printf("test(): %d > 0 ", num); return num > 0;};
		MyPredicate<Integer> isNegative = (num) -> {System.out.printf("test(): %d < 0 ", num); return num < 0;};
		MyPredicate<Integer> isEven = (num) -> {System.out.printf("test(): %d %% 2 == 0 ", num); return num % 2 == 0;};

		boolean result = isPositive.and(isEven).or(isNegative.and(isEven)).test(-4);
		// or: and: test(): 4 > 0 test(): 4 % 2 == 0							=> true
		// or: and: test(): 3 > 0 test(): 3 % 2 == 0 and: test(): 3 < 0			=> false
		// or: and: test(): -4 > 0 and: test(): -4 < 0 test(): -4 % 2 == 0		=> true
		// or: and: test(): -3 > 0 and: test(): -3 < 0 test(): -3 % 2 == 0 		=> false
		Assert.assertTrue(result);
	}
}
