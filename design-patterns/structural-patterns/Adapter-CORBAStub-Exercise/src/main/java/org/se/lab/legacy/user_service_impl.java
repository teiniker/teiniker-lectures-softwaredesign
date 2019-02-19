package org.se.lab.legacy;

import org.omg.CORBA.BooleanHolder;


/*
 * This test double class simulates a remote service implemented in C.
 */

public class user_service_impl 
	implements user_service // generated from the IDL compiler
{
	private int id;
	private String username;
	private String password;
	
	public user_service_impl()
	{
	}
	
	public void add_user(int id, String username, String password)
	{
		this.id = id;
		this.username = username;
		this.password = password;
	}

	
	public void login_user(String username, String password, BooleanHolder success)
	{
		/*
		 * Note that success is an "out" parameter, thus, we have to use a holder object
		 * to pass a value back to the caller.
		 */
		
		if(this.username.equals(username) && this.password.equals(password))
		{
			success.value = true;
		}
		else
		{
			success.value = false;
		}
	}
}
