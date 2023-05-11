package org.se.lab;

import org.junit.Test;


public class CustomAssertionsWithBuilderTest
{

	@Test
	public void testExpectedObject()
	{
		User u = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

		// verify
		User expected = new UserBuilder()
				.id(7)
				.username("homer")
				.password("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=")
				.build();

		CustomAssert.assertEquals(expected, u);
	}
}
