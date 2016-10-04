package org.se.lab;

import java.util.List;

public abstract class XMLElement 
{
    /* Define a single TAB string */
	public final static String TAB = "    ";
	
	
	/*
	 * Generate an XML String using the given number of indents.
	 * 
	 * Note that this is an abstract method, thus, each subclass
	 * has to implement this operation.
	 */
	public abstract String toXML(int indent);

	public String toXML()
	{
	    // Per default, we start with 0 TABs indent.
	    return toXML(0); 
	}

		
	/* 
	 * Child managing operations.
	 */
	List<XMLElement> getItems()
	{
        // Default implementation
        throw new UnsupportedOperationException();	    
	}
	public void addItem(XMLElement element)
	{
	    // Default implementation
	    throw new UnsupportedOperationException();
	}
	public void removeItem(XMLElement element)
	{
	    // Default implementation
	    throw new UnsupportedOperationException();
	}
	   
	
	/*
	 * Converts the given number of indents into a corresponding
	 * string of spaces.
	 * 
	 * @param number of indents.
	 * @return a string that represents the indents as spaces.
	 */
	protected String getIndentAsString(int indent)
	{
		StringBuilder spaces = new StringBuilder();
		for(int i = 0; i < indent ; i++)
		{
			spaces.append(TAB);
		}
		return spaces.toString();
	}
}
