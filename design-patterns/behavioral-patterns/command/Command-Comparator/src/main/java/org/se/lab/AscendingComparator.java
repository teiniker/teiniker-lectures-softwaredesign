package org.se.lab;

import java.util.Comparator;

public class AscendingComparator 
	implements Comparator<Integer>
{
	@Override
	public int compare(Integer a, Integer b)
	{
		if (a < b)
			return 1;
		else if (a > b)
			return -1;
		else
			return 0;
	}
}
