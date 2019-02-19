package org.se.lab;

public class User
{
	/*
	 * Constructor
	 */
	public User(int id, String username, String password)
	{
		setId(id);
		setUsername(username);
		setPassword(password);
	}
	
	
	/*
	 * Property: id:int
	 */
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	
	/*
	 * Property: username:String
	 */
	private String username;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		if(username == null)
			throw new IllegalArgumentException();
		this.username = username;
	}
	
	
	/*
	 * Property: password:String
	 */
	private String password;
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		if(password == null)
			throw new IllegalArgumentException();
		this.password = password;
	}
	
	
	/*
	 * Object methods
	 */

	@Override
	public boolean equals(Object o)
	{
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;
		return id == user.id;
	}

	@Override
	public int hashCode()
	{
		return id;
	}


	@Override
	public String toString()
	{
		return getId() + "," + getUsername();
	}
}
