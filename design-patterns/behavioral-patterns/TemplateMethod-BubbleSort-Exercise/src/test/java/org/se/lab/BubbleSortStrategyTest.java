package org.se.lab;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortStrategyTest
{
	protected SorterFactory factory;

	@Before
	public void setup()
	{
		factory = new SorterFactoryStrategyImpl();
	}


	@Test
	public void testAscenting()
	{
		BubbleSort bubble = factory.createSorter(SortDirection.ASCENDING);

		int[] result = bubble.sort(7, 3, 19, 123, 2, 13);

		Assert.assertEquals("[2, 3, 7, 13, 19, 123]", Arrays.toString(result));
	}

	@Test
	public void testDescending()
	{
		BubbleSort bubble = factory.createSorter(SortDirection.DESCENDING);

		int[] result = bubble.sort(7, 3, 19, 123, 2, 13);

		Assert.assertEquals("[123, 19, 13, 7, 3, 2]", Arrays.toString(result));
	}
}
