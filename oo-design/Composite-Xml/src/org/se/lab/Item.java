package org.se.lab;

public class Item 
	extends XMLElement 
{

	/* 
	 * Constructor 
	 */	
	public Item(String text) 
	{
		setText(text);
	}

	
	/*
	 * Property: text
	 */
	private String text;
	public final String getText() 
	{
		return text;
	}
	public final void setText(final String text) 
	{
		if(text == null)
			throw new NullPointerException("text");
		this.text = text;
	}
	
	
	/**
	 * Convert the text property into a proper XML element.
	 * e.g. <item>Some Text</item>
	 */
	public String toXML(final int indent)
	{
		return getIndentAsString(indent) 
				+ "<item>" + getText() + "</item>";
	}
}
