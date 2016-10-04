package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ItemList 
	extends XMLElement
{
	/**
	 * Property: items
	 */
    private List<XMLElement> items = new ArrayList<XMLElement>();
    public List<XMLElement> getItems()
    {
        return Collections.unmodifiableList(items);
    }
	public void addItem(final XMLElement element)
	{
		if(element == null)
			throw new NullPointerException("element");
		items.add(element);
	}
    public void removeItem(final XMLElement element)
    {
		if(element == null)
			throw new NullPointerException("element");
        items.remove(element);
    }
	
	
	/**
	 * Convert a list of XMLElements into a well formed XML tree.
	 * e.g. <itemlist>
	 *         <item>one</item>
	 *         <itemlist>
	 *             <item>two</item>
	 *         </itemlist>
	 *      </itemlist>
	 *      
	 * Note that an ItemList is also an XMLElement and therefore
	 * we can add it to the list as well as a regular Item element.     
	 */
	public String toXML(final int indent)
	{
	    String spaces = getIndentAsString(indent);
	    StringBuilder s = new StringBuilder();
	    s.append(spaces).append("<itemlist>\n");
		for(XMLElement element : items) // for all loop
		{
			s.append(element.toXML(indent+1)).append("\n");
		}
		s.append(spaces).append("</itemlist>");
		return s.toString(); 
	}
}
