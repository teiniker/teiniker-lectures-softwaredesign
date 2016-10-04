package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class UserTest
{
	@Test
	public void testInitConstructor()
	{
		User user = new User(1,"homer", "xxxxxxxxxx");
		
		Assert.assertEquals(1, user.getId());
		Assert.assertEquals("homer", user.getUsername());
		Assert.assertEquals("xxxxxxxxxx", user.getPassword());
		Assert.assertNotNull(user.getMails());
		Assert.assertEquals(0, user.getMails().size());
	}

	@Test
	public void testConstructor()
	{
		User user = new User("homer", "xxxxxxxxxx");
		
		Assert.assertEquals(0, user.getId());
		Assert.assertEquals("homer", user.getUsername());
		Assert.assertEquals("xxxxxxxxxx", user.getPassword());
		Assert.assertNotNull(user.getMails());
		Assert.assertEquals(0, user.getMails().size());
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidId()
	{
		new User(-1, "lisa", "*****");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidUsername()
	{
		new User(1, null, "*****");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPassword()
	{
		new User(1, "lisa", null);
	}
	
	
	@Test
	public void testAddMail()
	{
		User user = new User(1, "homer", "**********");
		user.addMail(new Mail("homer@springfield.com"));
		user.addMail(new Mail("homer@powerplant.com"));
		
		Assert.assertEquals(2, user.getMails().size());
		Assert.assertEquals("homer@springfield.com", user.getMails().get(0).getAddress());
		Assert.assertEquals("homer@powerplant.com", user.getMails().get(1).getAddress());
	}

	
	@Test
	public void testMailNavigation()
	{
		User user = new User(1, "homer", "**********");
		user.addMail(new Mail("homer@springfield.com"));

		Assert.assertEquals("homer@springfield.com", user.getMails().get(0).getAddress());
		Assert.assertEquals("homer", user.getMails().get(0).getOwner().getUsername());
	}
	
	
	@Test
	public void testToString()
	{
		User user = new User(1, "homer", "**********");
		
		Assert.assertEquals("User [id=1, username=homer, password=**********]", user.toString());
	}
	
	@Test
	public void testHashCodeAndEquas()
	{
		User user1 = new User(1, "homer", "**********");
		User user2 = new User(1, "homi", "xxxxxxxxx");
		
		Assert.assertEquals(user1.hashCode(), user2.hashCode());
		Assert.assertTrue(user1.equals(user2));
		Assert.assertTrue(user2.equals(user1));
	}
	
	
	@Test
	public void testEquals_SameObject()
	{
		User user = new User(1, "homer", "**********");
		
		Assert.assertTrue(user.equals(user));
	}

	@Test
	public void testEquals_Null()
	{
		User user = new User(1, "homer", "**********");
		
		Assert.assertFalse(user.equals(null));
	}

	@Test
	public void testEquals_WrongType()
	{
		User user = new User(1, "homer", "**********");
		
		Assert.assertFalse(user.equals(""));
	}

	@Test
	public void testEquas_WrongId()
	{
		User user1 = new User(1, "homer", "**********");
		User user2 = new User(2, "homi", "xxxxxxxxx");
		
		Assert.assertFalse(user1.equals(user2));
	}

}
