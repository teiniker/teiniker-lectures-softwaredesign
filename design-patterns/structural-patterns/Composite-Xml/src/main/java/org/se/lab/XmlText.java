package org.se.lab;

public class XmlText
	extends XmlNode
{

	/* 
	 * Constructor 
	 */	
	public XmlText(String text)
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
			throw new IllegalArgumentException("text is null!");
		this.text = text;
	}
	
	
	/**
	 * Convert the text property into a proper XML element.
	 * e.g. <item>Some Text</item>
	 */
	public String toXML()
	{
		return getText();
	}
}
