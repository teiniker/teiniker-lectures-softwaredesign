package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest
{
	private User homer;
	
	@Before
	public void setup()
	{
		homer = new User(7, "homer", "**********");
	}
	
	
	@Test
	public void testConstructor()
	{
		Assert.assertEquals(7, homer.getId());
		Assert.assertEquals("homer", homer.getUsername());
		Assert.assertEquals("**********", homer.getPassword());
	}

	
	@Test(expected=IllegalArgumentException.class)
	public void testId_invalidValue()
	{
		new User(-7, "homer", "**********");
	}
}
