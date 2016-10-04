package org.se.lab;

public class BeanValidationObserver
	implements Observer
{

	@Override
	public void update(Subject subject)
	{
		// cast subject to the real subject type
		if(!(subject instanceof Bean)) 
			throw new IllegalArgumentException();
			
		Bean element = (Bean)subject;
		
		if(element.getName() == null 
			|| element.getName().length() < 4 || element.getName().length() > 32)
		{
			throw new IllegalStateException("Illegal state name " + element.getName());
		}
	
		if(element.getId() < 0)
		{
			throw new IllegalStateException("Illegal state id");
		}
	}
}
