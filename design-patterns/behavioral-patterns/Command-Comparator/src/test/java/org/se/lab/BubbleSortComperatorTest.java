package org.se.lab;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortComperatorTest
{
	protected BubbleSort sorter;

	@Before
	public void setup()
	{
		sorter = new BubbleSort();
	}


	@Test
	public void testAscending()
	{
		Comparator<Integer> c = new AscendingComparator();
		int[] result = sorter.sort(c, 7, 3, 19, 123, 2, 13);

		Assert.assertEquals("[2, 3, 7, 13, 19, 123]", Arrays.toString(result));
	}

	@Test
	public void testDescending()
	{
		Comparator<Integer> c = new DescendingComparator();

		int[] result = sorter.sort(c, 7, 3, 19, 123, 2, 13);

		Assert.assertEquals("[123, 19, 13, 7, 3, 2]", Arrays.toString(result));
	}
}
