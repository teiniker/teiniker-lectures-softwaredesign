package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class EqualsVersusSameTest
{
	@Test
	public void testEquals()
	{
		User u = new User(7, "homer", "tLgR+kBQUymuhx5S8DUnw3IMmvf7hgeBllhTXFSExB4=");

		// verify
        User expected = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        Assert.assertEquals(expected,u);
	}


	@Test
	public void testSame()
	{
		User u1 = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
		User u2 = u1;

		// verify
        User expected = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        Assert.assertEquals(expected, u1);
        Assert.assertEquals(expected, u2);

        Assert.assertNotSame(expected,u2);
		Assert.assertSame(u1,u2);
	}
}
