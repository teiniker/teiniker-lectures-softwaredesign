package org.se.lab;

import org.junit.Before;

public abstract class AbstractContainerTest
{
	protected Component component;
	
	/*
	 * lineup
	 *   +-- box
	 *         +-- DVD
	 *         +-- CD
	 *         +-- Book
	 *   +-- carton
	 *         +-- TVSet      
	 */
	
	@Before
	public void setup()
	{
		component = new Container("lineup");
		
		Container b1 = new Container("box");
		component.addComponent(b1);	
		b1.addComponent(new Product("DVD", 200, 1990));
		b1.addComponent(new Product("CD", 150, 1390));
		b1.addComponent(new Product("Book", 500, 3980));
		
		Container b2 = new Container("carton");
		component.addComponent(b2);
		b2.addComponent(new Product("TVSet", 12000, 99990));		
	}
}
