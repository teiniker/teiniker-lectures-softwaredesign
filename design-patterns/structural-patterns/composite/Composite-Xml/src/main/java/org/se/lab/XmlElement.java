package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class XmlElement
	extends XmlNode
{
	/*
	 * Constructor
	 */
	public XmlElement(String name)
    {
        setName(name);
    }

    /*
	 * Property: name
	 */
	private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        if(name == null)
            throw new IllegalArgumentException("Name is null!");
        this.name = name;
    }


    /*
	 * Association: ---[*]-> XmlNode
	 */
    private List<XmlNode> nestedElements = new ArrayList<XmlNode>();
    public List<XmlNode> getNestedElements()
    {
        return nestedElements;
    }
	public void addNestedElement(final XmlNode element)
	{
		if(element == null)
			throw new IllegalArgumentException("Nested element is null!");
		nestedElements.add(element);
	}
    public void removeItem(final XmlNode element)
    {
		if(element == null)
			throw new IllegalArgumentException("Nested element is null!");
        nestedElements.remove(element);
    }

    /*
     * Operation
     */
	public String toXML()
	{
	    StringBuilder s = new StringBuilder();
	    s.append('<').append(getName()).append('>');
		for(XmlNode element : nestedElements)
		{
			s.append(element.toXML());
		}
        s.append('<').append('/').append(getName()).append('>');
		return s.toString();
	}
}
