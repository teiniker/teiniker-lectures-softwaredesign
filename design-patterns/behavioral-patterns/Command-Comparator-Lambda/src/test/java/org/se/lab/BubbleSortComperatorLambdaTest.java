package org.se.lab;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortComperatorLambdaTest
{
	protected BubbleSort sorter;

	@Before
	public void setup()
	{
		sorter = new BubbleSort();
	}

	
	@Test
	public void testAscendingSorting()
	{
		Comparator<Integer> c = (a,b) -> {
			if(a < b)
				return 1;
			else if(a > b)
				return -1;
			else
				return 0;
		};
		
		int[] result = sorter.sort(c, 7, 3, 19, 123, 2, 13);

		Assert.assertEquals("[2, 3, 7, 13, 19, 123]", Arrays.toString(result));
	}
	
	
	@Test
	public void testDescendingSorting()
	{
		                    //  int compare(T o1, T o2);
		Comparator<Integer> c = (a,b) -> a-b;

		int[] result = sorter.sort(c, 7, 3, 19, 123, 2, 13);

		Assert.assertEquals("[123, 19, 13, 7, 3, 2]", Arrays.toString(result));
	}
}
