package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserAndMailTest
{
	private User user;
	
	
	@Before
	public void setup()
	{
		user = new User(3,"bart", "****");
		
		EMail m1 = new EMail(4, "bart.simpson@springfield.com");
		EMail m2 = new EMail(5, "bart.simpson@school.org");

		user.getMails().add(m1);
		user.getMails().add(m2);
	}
	
	@Test
	public void testNavigation()
	{
		EMail m = user.getMails().get(0);
		Assert.assertEquals(4, m.getId());
		
		Assert.assertEquals(5, user.getMails().get(1).getId());
	}
}
