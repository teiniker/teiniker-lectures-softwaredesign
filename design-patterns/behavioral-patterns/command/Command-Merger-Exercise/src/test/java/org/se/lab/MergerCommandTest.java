package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class MergerCommandTest
{
	@Test
	public void testMergerCommandAND()
	{
		MergerCommand command = new MergerCommandAND();
		
		int actual = command.merge(0B00001111, 0B11111111);
		int expected = 0B00001111 & 0B11111111;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMergerCommandXOR()
	{
		MergerCommand command = new MergerCommandXOR();
		
		int actual = command.merge(0B00001111, 0B11111111);
		int expected = 0B00001111 ^ 0B11111111;
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testMergerCommandMAX()
	{
		MergerCommand command = new MergerCommandMAX();
		
		int actual = command.merge(6666, 9999);
		int expected = 9999;
		Assert.assertEquals(expected, actual);
	}
	

}
