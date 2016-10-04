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
	private String rootPassword;
	public String getRootPassword()
	{
		return rootPassword;
	}
	public void setRootPassword(String rootPassword)
	{
		if(rootPassword == null)
			throw new IllegalArgumentException();
		this.rootPassword = rootPassword;
	}

	
	
	/*
	 * Object methods
	 */
	
	@Override
	public String toString()
	{
		return "Admin [RootPassword=" + rootPassword + "]";
	}	
}
