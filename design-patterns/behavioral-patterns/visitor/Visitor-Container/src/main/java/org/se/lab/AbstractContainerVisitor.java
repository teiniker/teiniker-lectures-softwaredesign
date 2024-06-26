package org.se.lab;

public abstract class AbstractContainerVisitor
	implements ContainerVisitor
{
	@Override
	public void visit(Container container)
	{
	    // calculate 
	    
	    // navigation
		container.getComponents().forEach(c -> visit(c));
	}

	
	@Override
	public void visit(Component component)
	{
		// calculate

		// navigation
		if(component instanceof Product)
		{
			visit((Product)component);
		}
		else if(component instanceof Container)
		{
			visit((Container)component);
		}
		else
		{
		    throw new IllegalArgumentException();
		}
	}
}
