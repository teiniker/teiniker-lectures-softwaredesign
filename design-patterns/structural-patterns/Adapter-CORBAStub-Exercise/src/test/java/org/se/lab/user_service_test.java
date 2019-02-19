package org.se.lab;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.BooleanHolder;
import org.se.lab.legacy.user_service;
import org.se.lab.legacy.user_service_impl;

public class user_service_test
{
	private user_service service;
	
	@Before
	public void setup() throws IOException
	{
        service = new user_service_impl();
	}

	@Test
	public void testLoginSuccess()
	{
		// Invoke methods on the CORBA object's interface.
		service.add_user(7, "homer", "xxxxxxxxxx");
		BooleanHolder holder = new BooleanHolder();
		service.login_user("homer", "xxxxxxxxxx", holder);
		
		// verify
		Assert.assertTrue(holder.value);
	}

	
	@Test
	public void testLoginFailure()
	{
		// Invoke methods on the CORBA object's interface.
		service.add_user(7, "homer", "xxxxxxxxxx");
		BooleanHolder holder = new BooleanHolder();
		service.login_user("homer", "**********", holder);

		// verify
		Assert.assertFalse(holder.value);
	}
}
