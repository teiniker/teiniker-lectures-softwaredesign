package org.se.lab;

class ValidationDecorator // package private
	extends LoginServiceDecorator
{
	/*
	 * Constructor Injection
	 */
	public ValidationDecorator(LoginService service)
	{
		super(service);
	}
	
	
	@Override
	public void addUser(int id, String username, String password, String mail)
	{
		// pre-processing
		if(id < 0)
			throw new IllegalArgumentException();
		if(username == null)
			throw new IllegalArgumentException();
		if(password == null)
			throw new IllegalArgumentException();
		if(mail == null)
			throw new IllegalArgumentException();
		
		super.addUser(id, username, password, mail);
	}

	@Override
	public boolean login(String username, String password)
	{
		// pre-processing
		if(username == null)
			throw new IllegalArgumentException();
		if(password == null)
			throw new IllegalArgumentException();
		
		return super.login(username, password);
	}

}
