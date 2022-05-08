package org.se.lab;

import java.util.List;

public abstract class XmlNode
{
	/*
	 * Operation
	 */
	public abstract String toXML();

		
	/* 
	 * Child managing operations.
	 */
	List<XmlNode> getNestedElements()
	{
        throw new UnsupportedOperationException();
	}
	public void addNestedElement(XmlNode element)
	{
	    throw new UnsupportedOperationException();
	}
}
