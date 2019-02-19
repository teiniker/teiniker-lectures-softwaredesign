package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.legacy.user_service_impl;

public class UserServiceAdapterTest
{
	private UserService service;
	
	@Before
	public void setup()
	{
		service = new UserServiceAdapter(new user_service_impl());
	}

	
	@Test
	public void testLoginSuccess()
	{
		// setup
		service.addUser(new User(7, "homer", "xxxxxxxxxx"));

		// exercise
		boolean result = service.loginUser("homer", "xxxxxxxxxx");
		
		// verify
		Assert.assertTrue(result);
	}

	
	@Test
	public void testLoginFailure()
	{
		// setup
		service.addUser(new User(7, "homer", "xxxxxxxxxx"));
		
		// exercise
		boolean result = service.loginUser("homer", "**********");

		// verify
		Assert.assertFalse(result);
	}	
}
