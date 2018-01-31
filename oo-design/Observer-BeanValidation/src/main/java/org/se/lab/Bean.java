package org.se.lab;

public class Bean
	extends Subject
{
	/*
	 * Constructor
	 */
	public Bean(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	/*
	 * Property: id
	 */
	private int id;
	public final int getId()
	{
		return id;
	}
	public final void setId(int id)
	{
		this.id = id;
		notifyObservers();
	}


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
		this.name = name;
		notifyObservers(); 
	}	
}
