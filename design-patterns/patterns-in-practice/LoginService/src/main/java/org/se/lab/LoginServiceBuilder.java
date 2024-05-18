package org.se.lab;

import java.util.Stack;

public class LoginServiceBuilder
{
	/*
	 * Note that the decorators must be connected in reverse order of the
	 * builder method invocations.
	 * So we use a stack to hold all decorator instances and at the end of
	 * the building process, we connect the decorators in the right order. 
	 */
	private Stack<LoginServiceDecorator> stack = new Stack<LoginServiceDecorator>();
	
		
	public LoginServiceBuilder withValidation()
	{
		stack.push(new ValidationDecorator(null));
		return this;
	}

	public LoginServiceBuilder withEncoding()
	{
		stack.push(new EncodingDecorator(null));
		return this;
	} 
	
	public LoginServiceBuilder withLogging()
	{
		stack.push(new LoggingDecorator(null));
		return this;
	} 
	
	public LoginService toService()
	{
		LoginService service = new LoginServiceImpl();
	
		while(!stack.isEmpty())
		{
			LoginServiceDecorator decorator = stack.pop();
			decorator.setService(service);
			service = decorator;
		}
		return service;
	}
}
