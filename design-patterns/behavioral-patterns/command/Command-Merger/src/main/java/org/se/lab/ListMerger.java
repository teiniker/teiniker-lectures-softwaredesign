package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ListMerger
{
	public List<Integer> merge(List<Integer> listA, List<Integer> listB, MergerCommand merger) 
	{
		if(!checkLists(listA, listB))
			throw new IllegalArgumentException();
		
		if(merger == null)
			throw new IllegalArgumentException("Parameter MergeCommand is null!");
		
		List<Integer> result = new ArrayList<Integer>();
		for(int i=0; i<listA.size(); i++)
		{
			int a = listA.get(i);
			int b = listB.get(i);
			result.add(merger.merge(a, b));
		}
		return result;
	}
	
	
	protected boolean checkLists(List<Integer> listA, List<Integer> listB)
	{
		if(listA.size() == listB.size())
			return true;
		else
			return false;
	}
}
