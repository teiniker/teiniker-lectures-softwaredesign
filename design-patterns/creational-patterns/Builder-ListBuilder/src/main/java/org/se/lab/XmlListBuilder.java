package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class XmlListBuilder 
	implements ListBuilder
{
	private List<String> list = new ArrayList<String>();
		
	@Override
	public ListBuilder item(String s)
	{
		list.add(s);
		return this;
	}
	
	public String toXml()
	{
		StringBuilder out = new StringBuilder();
		out.append("<list>\n");
		for(String item : list)
		{
			out.append("\t<item>").append(item).append("</item>\n");
		}
		out.append("</list>");
		return out.toString();
	}
}
