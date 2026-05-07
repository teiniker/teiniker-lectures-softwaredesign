package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Area
{
    /*
     * Constructor
     */
	public Area(String description) 
	{
		setDescription(description);
	}


	/*
	 *  Property: description:String
	 */
	private String description;
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
	    if(description == null)
	        throw new IllegalArgumentException("Description is null!");
	    this.description=description;
	}
	
	
	/*
	 * Association: --[*]-> locations:Location
	 */
	private List<Location> locations = new ArrayList<Location>();
	public List<Location> getLocations()
	{
		return this.locations;
	}
	public void addLocation(Location location)
	{
		if (location == null)
			throw new IllegalArgumentException("Location is null!");
		
		this.locations.add(location);
	}	
}
