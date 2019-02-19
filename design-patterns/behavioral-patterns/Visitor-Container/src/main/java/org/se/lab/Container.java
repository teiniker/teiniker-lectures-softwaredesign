package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Container
	extends Component
	
{
	/*
	 * Constructor
	 */
	public Container(String name)
	{
		setName(name);
	}
	
	
	/*
	 * Association: Package ---[*]-> components:Component
	 */
	private List<Component> components = new ArrayList<Component>();
	public void addComponent(Component c)
	{
		if(c == null)
			throw new IllegalArgumentException();
		components.add(c);
	}
	public List<Component> getComponents()
	{
		return Collections.unmodifiableList(components);
	}	
}
