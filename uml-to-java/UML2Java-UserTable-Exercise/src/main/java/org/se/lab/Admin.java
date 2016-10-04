package org.se.lab;

public class Admin 
	extends User
{
	/*
	 * Constructors
	 */
	public Admin(int id, String username, String password, String rootPassword)
	{
		super(id,username,password);
		setRootPassword(rootPassword);
	}
	
	public Admin(String username, String password, String rootPassword)
	{
		this(0, username,password,rootPassword);
	}
	
	
	/*
	 * Property: RootPassword:String
	 */
	private String RootPassword;
	public String getRootPassword()
	{
		return RootPassword;
	}
	public void setRootPassword(String rootPassword)
	{
		if(rootPassword == null)
			throw new IllegalArgumentException();
		RootPassword = rootPassword;
	}

	
	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return "Admin [RootPassword=" + RootPassword + "]";
	}	
}
