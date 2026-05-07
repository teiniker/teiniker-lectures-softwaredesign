package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Warehouse 
{
    /*
     * Constructor
     */    
	public Warehouse(String name) 
	{
		setName(name);
	}


	/*
	 *  Property: name:String
	 */
	private String name;
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		if (name == null)
			throw new IllegalArgumentException("Name is null!");		
		this.name = name;
	}
	
	
	/*
	 * Association: --[*]-> areas:Area
	 */
	private List<Area> areas = new ArrayList<Area>();
	public List<Area> getAreas()
	{
		return this.areas;
	}
	public void addArea(Area area)
	{
		if (area == null)
			throw new IllegalArgumentException("Area is null!");	
		this.areas.add(area);
	}	
}
