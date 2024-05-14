package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class ParameterizedTest
{
	@Test
	public void testToString1()
	{
        verifyToString("homer");
	}

	@Test
	public void testToString2()
	{
        verifyToString("h");
	}
	
	@Test
	public void testToString3()
	{
        verifyToString("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}

	
	/*
	 * We can extract the common fixture setup, exercise SUT, and verify into a new
	 * parameterized test method. 
	 */
	private void verifyToString(String username)
	{
		User u = new User(7, username, "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
		
		// exercise
		String s = u.toString();

		// verify
		String expected = "7," + username;
		Assert.assertEquals(expected, s);
	}
}
