package org.se.lab;

import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Test;

public class SupplierTest
{
	@Test
	public void testGet()
	{
		Supplier<Integer> randomNumber = () -> new Random().nextInt();

		System.out.println("Random Number: " + randomNumber.get());
	}

	private String getBigData()
	{
		// LOad data from database...
		return "Lots of data!!";
	}

	@Test
	public void testBigData()
	{
		Supplier<String> bigData = this::getBigData;

		// Data is not loaded until get() is invoked
		System.out.println("Big Data: " + bigData.get());
	}

}
