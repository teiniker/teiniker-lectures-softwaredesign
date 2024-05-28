package org.se.lab;

public class User
{
	/*
	 * Initialization constructor
	 */
	public User(int id, String username, String password)
	{
		setId(id);
		setUsername(username);
		setPassword(password);
	}
	
	
	/*
	 * Property: id
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
	 * Property: username
	 */
	private String username;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		if(username == null 
				|| username.trim().length() == 0)
			throw new IllegalArgumentException("username: " + username);
		this.username = username;
	}
	
	
	/*
	 * Property: password
	 */
	private String password;
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		if(password == null || password.trim().length() == 0)
			throw new IllegalArgumentException("password: " + password);
		this.password = password;
	}
	

	/*
	 * Object methods
	 */

	@Override
	public String toString()
	{
		return getId() + "," + getUsername();
	}

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
}
