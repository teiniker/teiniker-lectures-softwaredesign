package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginServiceTest
{
	protected LoginService service;
	
	@Before
	public void setup()
	{
		service = new LoginServiceImpl();
		
		service.addUser(1, "lisa", "superlisa", "lisa.simpson@springfield.com");
		service.addUser(1, "bart", "karramba", "bart.simpson@springfield.com");
	}
	
	@Test
	public void testLoginSuccess()
	{
		Assert.assertTrue(service.login("lisa", "superlisa"));
	}

	@Test
	public void testLoginFailure_WrongUsername()
	{
		Assert.assertFalse(service.login("homer", "superlisa"));
	}

	@Test
	public void testLoginFailure_WrongPassword()
	{
		Assert.assertFalse(service.login("lisa", "sillylisa"));
	}
}
