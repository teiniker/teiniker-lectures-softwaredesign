package org.se.lab;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortComperatorAnonymousClassTest
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
		Comparator<Integer> comp = new Comparator<Integer>()
		{
		    public int compare(Integer a, Integer b)
		    {
    			return b-a;
		    }
		};
		
		int[] result = sorter.sort(comp, 7, 3, 19, 123, 2, 13);

		Assert.assertEquals("[2, 3, 7, 13, 19, 123]", Arrays.toString(result));
	}
	
	
	@Test
	public void testDescendingSorting()
	{
		Comparator<Integer> comp = new Comparator<Integer>()
        {
		    public int compare(Integer a, Integer b)
		    {
		        return a-b;
		    }
        };

		int[] result = sorter.sort(comp, 7, 3, 19, 123, 2, 13);

		Assert.assertEquals("[123, 19, 13, 7, 3, 2]", Arrays.toString(result));
	}
}
