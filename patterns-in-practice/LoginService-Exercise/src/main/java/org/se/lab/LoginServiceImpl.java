package org.se.lab;

import java.util.ArrayList;
import java.util.List;

class LoginServiceImpl // package private 
	implements LoginService
{
	/*
	 * Simulate database table with a List<User>
	 */
	private List<User> users = new ArrayList<User>();
	protected List<User> getUsers()
	{
		return users;
	}
	
	
	public void addUser(int id, String username, String password, String mail)
	{
		User user = new User(id, username, password, mail);
		users.add(user);
	}

	
	public boolean login(String username, String password)
	{
		for(User user: users)
		{
			if(user.getUsername().equals(username) && 
					user.getPassword().equals(password))
				return true;
		}
		return false;
	}

	
	public void logout()
	{
		// Here we do not manage any session state therefore we do
		// also nothing for log out.
	}
}
