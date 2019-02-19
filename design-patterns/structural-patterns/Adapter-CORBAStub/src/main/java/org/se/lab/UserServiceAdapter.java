package org.se.lab;

import org.omg.CORBA.BooleanHolder;
import org.se.lab.legacy.user_service;


public class UserServiceAdapter
	implements UserService
{
	/*
	 * Constructor injection
	 */
	
	public UserServiceAdapter(user_service service)
	{
	    if(service == null)
	        throw new IllegalArgumentException("Invalid service reference!");
	    
		this.service = service;
	}
	
	
	/*
	 * Association: ---[1]-> user_service 
	 */
	private user_service service;
		
	
	/*
	 * UserService Operations
	 */
	
	public void addUser(User user)
	{
		// Convert parameters
		int id = user.getId();
		String username = user.getUsername();
		String password = user.getPassword();
		
		// delegate to legacy code
		service.add_user(id, username, password);
	}

	public boolean loginUser(String username, String password)
	{
		// Convert an out parameter into a return value
		BooleanHolder holder = new BooleanHolder();
		service.login_user(username, password, holder);
		return holder.value;
	}
}
