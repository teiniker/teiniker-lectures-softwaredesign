package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class TxtListBuilder 
	implements ListBuilder
{
	private List<String> list = new ArrayList<String>();
		
	@Override
	public ListBuilder item(String s)
	{
		list.add(s);
		return this;
	}
	
	public String toText()
	{
		StringBuilder out = new StringBuilder();
		out.append("list:\n");
		for(String item : list)
		{
			out.append("\t- ").append(item).append("\n");
		}
		return out.toString();
	}	
}
