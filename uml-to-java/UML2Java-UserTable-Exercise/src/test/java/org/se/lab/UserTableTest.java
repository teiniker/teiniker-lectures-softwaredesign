package org.se.lab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTableTest 
{
	private UserTable table;
	
	@Before
	public void setUp()  
	{
		table = new UserTableImpl();
		User user = new User("homer", "*****");
		table.insertUser(user);		
	}

	@After
	public void tearDown()  
	{
		IntegerSequence.setInitValue(1);  // reset
	}

	@Test
	public void testFindById() 
	{
		// exercise
		User result = table.findById(1);
		
		Assert.assertNotNull(result);

		// verify
		Assert.assertEquals("homer", result.getUsername());	
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFindById_InvalidId()
	{
		table.findById(-1);
	}
	
}
