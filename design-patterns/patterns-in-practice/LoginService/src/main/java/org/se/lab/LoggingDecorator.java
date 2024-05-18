package org.se.lab;

import java.util.logging.Logger;

class LoggingDecorator // package private
	extends LoginServiceDecorator
{
	/*
	 * Constructor Injection
	 */
	public LoggingDecorator(LoginService service)
	{
		super(service);
	}

	
	private static Logger logger = Logger.getLogger("org.se.lab");	
	
	@Override
	public void addUser(int id, String username, String password, String mail)
	{
		logger.info("parameters: " + id + "," + username + "," + password + "," + mail);
		super.addUser(id, username, password, mail);
	}
	
	@Override
	public boolean login(String username, String password)
	{
		logger.info("parameters: " + username + "," + password);
		boolean result = super.login(username, password); 
		logger.info("result: " + result);
		return result;
	}
	
	@Override
	public void logout()
	{
		logger.info("");
		super.logout();
	}
}
