package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class UserTableImpl
	implements UserTable
{
	/*
	 * Simulate a database table:
	 * Association: ---[*]-> User
	 */
	private List<User> users = new ArrayList<User>();
	
	
	/*
	 * Operations
	 */
	
	public void insertUser(User user)
	{
		if(user == null)
			throw new IllegalArgumentException();
		
		user.setId(IntegerSequence.getNextValue());
		users.add(user);
	}

	
	public User findById(int id)
	{
		if(id < 0)
			throw new IllegalArgumentException();
		
		User result = null;
		
		for(User u : users)
		{
			if(u.getId() == id)
			{
				result = u;
			}
		}
		return result;
	}
	
	
	public List<User> findAll()
	{
		return users;
	}
}
