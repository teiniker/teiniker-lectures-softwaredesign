package org.se.lab;


public class User
{
	/*
	 * Constructors
	 */
	public User(int id, String username, String password, String mail)
	{
		setId(id);
		setUsername(username);
		setPassword(password);
		setMail(mail);
	}
	

	/*
	 * Property: id
	 */
	private int id;
	public final int getId()
	{
		return id;
	}
	public final void setId(final int id)
	{
		this.id = id;
	}
	

	/*
	 * Property: username
	 */
	private String username;
	public final String getUsername()
	{
		return username;
	}
	public final void setUsername(String name)
	{
		this.username = name;
	}
	
	/*
	 * Property: password
	 */
	private String password;
	public final String getPassword()
	{
		return password;
	}
	public final void setPassword(String passwd)
	{
		this.password = passwd;
	}
	
	
	/*
	 * Property: mail
	 */
	private String mail;
	public String getMail()
	{
		return mail;
	}
	public void setMail(String mail)
	{
		this.mail = mail;
	}
}
