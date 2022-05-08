package org.se.lab;

import java.util.List;


public abstract class Component
{
	/*
	 * Property: name:String
	 */
	private String name;
	public final String getName()
	{
		return name;
	}
	public final void setName(String name)
	{
		if(name == null)
			throw new IllegalArgumentException();
		this.name = name;
	}

		
	/*
	 * Navigation
	 */
	
	public void addComponent(Component c)
	{
		throw new UnsupportedOperationException();
	}
	public List<Component> getComponents()
	{
		throw new UnsupportedOperationException();
	}
}
