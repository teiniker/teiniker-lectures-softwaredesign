package org.se.lab;

import java.util.List;

public class ListMerger
{
	public List<Integer> merge(List<Integer> listA, List<Integer> listB, MergerCommand merger) 
	{
		if(!checkLists(listA, listB))
			throw new IllegalArgumentException();
		
		
		// TODO
		
		return null;
	}
		
	protected boolean checkLists(List<Integer> listA, List<Integer> listB)
	{
		if(listA.size() == listB.size())
			return true;
		else
			return false;
	}
}
