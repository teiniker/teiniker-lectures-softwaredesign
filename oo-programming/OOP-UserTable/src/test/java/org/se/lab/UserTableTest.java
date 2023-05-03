package org.se.lab;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTableTest
{
	private UserTable table;
		
	
	@Before
	public void setup()
	{	
		table = new UserTableImpl();
		table.insertUser(new User("bart", "****"));
		table.insertUser(new Admin("lisa", "****", "!!!!!!!"));
	}

	@After
	public void teardown()
	{
		IntegerSequence.setInitValue(1);	// reset sequence	
	}
	

	@Test
	public void testFindById()
	{
		User user = table.findById(2);
		
		Assert.assertTrue(user instanceof Admin);
		Admin admin = (Admin)user;
		
		Assert.assertNotNull(user);
		Assert.assertEquals("lisa", user.getUsername());
		Assert.assertEquals("****", user.getPassword());
		Assert.assertEquals("!!!!!!!", admin.getRootPassword());
	}
	
	@Test
	public void testFindAll()
	{
		List<User> users = table.findAll();
		
		Assert.assertEquals(2, users.size());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testInsertUser_Null()
	{
		table.insertUser(null);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testFindUserById_InvalidId()
	{
		table.findById(-1);
	}
}
