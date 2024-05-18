package org.se.lab;

abstract class LoginServiceDecorator // package private
	implements LoginService
{
	private LoginService service;
	protected void setService(LoginService service)
	{
		this.service = service;
	}
	
	
	/*
	 * Constructor Injection
	 */
	public LoginServiceDecorator(LoginService service)
	{
		setService(service);
	}
	
	
	@Override
	public void addUser(int id, String username, String password, String mail)
	{
		service.addUser(id, username, password, mail);
	}

	@Override
	public boolean login(String username, String password)
	{
		return service.login(username, password);
	}

	@Override
	public void logout()
	{
		service.logout();
	}
}
