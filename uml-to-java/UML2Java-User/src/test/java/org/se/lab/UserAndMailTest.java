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
		
		new EMail(4, "bart.simpson@springfield.com", user);
		new EMail(5, "bart.simpson@school.org", user);
	}
	
	@Test
	public void testNavigation()
	{
		EMail m = user.getMails().get(0);
		Assert.assertEquals(4, m.getId());
		
		Assert.assertEquals(5, user.getMails().get(1).getId());
	}

	
	@Test
	public void testNavigation2()
	{
		EMail m = user.getMails().get(0);
		User u = m.getUser();
		
		Assert.assertEquals("bart", u.getUsername());
		Assert.assertEquals(2,u.getMails().size());
		
		EMail m2 = u.getMails().get(1);
		Assert.assertEquals("bart.simpson@school.org", m2.getAddress());
	}
	
}
