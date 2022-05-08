package org.se.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListMergerTest
{
	private ListMerger merger;
	
	@Before
	public void setup()
	{
		merger = new ListMerger();
	}
		
	@Test
	public void testMergeAnd()
	{
		MergerCommand cmdAND = new MergerCommandAND();
		
		List<Integer> listA = Arrays.asList(0B00001111, 0B11110000, 0B11111111, 0B00000000);
		List<Integer> listB = Arrays.asList(0B11111111, 0B00000000, 0B11111111, 0B00000000);
		
		List<Integer> result = merger.merge(listA, listB, cmdAND);
		
		Assert.assertEquals(Integer.valueOf(0B00001111 & 0B11111111), result.get(0));
		Assert.assertEquals(Integer.valueOf(0B11110000 & 0B00000000), result.get(1));
		Assert.assertEquals(Integer.valueOf(0B11111111 & 0B11111111), result.get(2));
		Assert.assertEquals(Integer.valueOf(0B00000000 & 0B00000000), result.get(3));		
	}

	@Test
	public void testMergeMax()
	{
		MergerCommand cmdMAX = new MergerCommandMAX();
		
		List<Integer> listA = Arrays.asList(17, 2222, 99, 2012);
		List<Integer> listB = Arrays.asList(123, 2020, 100, 2013);
		
		List<Integer> result = merger.merge(listA, listB, cmdMAX);
		
		Assert.assertEquals(Integer.valueOf(123), result.get(0));
		Assert.assertEquals(Integer.valueOf(2222), result.get(1));
		Assert.assertEquals(Integer.valueOf(100), result.get(2));
		Assert.assertEquals(Integer.valueOf(2013), result.get(3));		
	}
	
	@Test
	public void testMergeXor()
	{
		MergerCommand cmdXOR = new MergerCommandXOR();
		
		List<Integer> listA = Arrays.asList(0B00001111, 0B11110000, 0B11111111, 0B00000000);
		List<Integer> listB = Arrays.asList(0B11111111, 0B00000000, 0B11111111, 0B00000000);
		
		List<Integer> result = merger.merge(listA, listB, cmdXOR);
		
		Assert.assertEquals(Integer.valueOf(0B00001111 ^ 0B11111111), result.get(0));
		Assert.assertEquals(Integer.valueOf(0B11110000 ^ 0B00000000), result.get(1));
		Assert.assertEquals(Integer.valueOf(0B11111111 ^ 0B11111111), result.get(2));
		Assert.assertEquals(Integer.valueOf(0B00000000 ^ 0B00000000), result.get(3));		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCheck()
	{
		MergerCommand cmdAND = new MergerCommandAND();
		
		List<Integer> listA = Arrays.asList(0B00001111, 0B11110000, 0B11111111);
		List<Integer> listB = Arrays.asList(0B11111111, 0B00000000, 0B11111111, 0B00000000);
		merger.merge(listA, listB, cmdAND);
	}
}
