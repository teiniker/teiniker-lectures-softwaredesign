package org.se.lab;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EncodingDecoratorTest
{
	protected LoginService service;
	protected LoginServiceImpl impl;
	
	@Before
	public void setup()
	{
		impl = new LoginServiceImpl();
		
		service = new EncodingDecorator(new LoggingDecorator(impl));
		
		service.addUser(1, "lisa", "superlisa", "lisa.simpson@springfield.com");
		service.addUser(2, "bart", "karramba", "bart.simpson@springfield.com");
	}

	
	@Test
	public void testLoginSuccess()
	{
		Assert.assertTrue(service.login("lisa", "superlisa"));
	}
	
	@Test
	public void testAddUserEncoding()
	{
		List<User> users = impl.getUsers();
		
		Assert.assertEquals("584ac1007be3d04e361fd6d3d2a28c9e15db348a0083c0ee2fd8c27a6ee4007b", users.get(0).getPassword());
		Assert.assertEquals("6a5777c32e3c5eabefc5c5ff7648a065098359d3e4d9ed776c633b0d2682ffd8", users.get(1).getPassword());
	}
}
