package org.se.lab;

import java.util.List;

public class InternalListIterator
{
	private InternalListIterator() {}
	
	public static void forEach(List<String> list, Command cmd)
	{
		for(int i =0; i < list.size(); i++)
		{
			String s = cmd.modify(list.get(i));
			list.set(i, s);
		}
	}
}
