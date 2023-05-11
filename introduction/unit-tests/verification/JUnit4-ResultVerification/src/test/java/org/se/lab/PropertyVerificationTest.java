package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class PropertyVerificationTest
{
    @Test
    public void testToString()
    {
        User u = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

        // verify
        String expected = "7,homer";
        Assert.assertEquals(expected , u.toString());
    }


	@Test
	public void testEachAttribute()
	{
		User u = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

		// verify
        Assert.assertEquals(7, u.getId());
		Assert.assertEquals("homer", u.getUsername());
		Assert.assertEquals("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=", u.getPassword());
	}
}
