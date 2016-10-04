package org.se.lab;

import java.util.ArrayList;
import java.util.List;

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
	
	public User(String username, String password)
	{
		this(0, username, password);
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
		if(id < 0)
			throw new IllegalArgumentException();
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
	 * Association: ---[*]-> Mail
	 */
	private List<Mail> mails = new ArrayList<Mail>();
	public List<Mail> getMails()
	{
		return mails;
	}	
	public void addMail(Mail mail)
	{
		mails.add(mail);		// User --> Mail
		mail.setOwner(this); 	// Mail ---> User
	}
	
	
	/*
	 * Object methods
	 */
	

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
