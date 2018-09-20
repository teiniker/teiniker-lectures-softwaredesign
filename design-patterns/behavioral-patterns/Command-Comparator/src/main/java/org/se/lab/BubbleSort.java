package org.se.lab;

import java.util.Comparator;

public class BubbleSort
{
	public int[] sort(Comparator<Integer> comp, int... data)
	{
		int len = data.length;
		int tmp = 0;
		for (int i = 0; i < len; i++)
		{
			for (int j = (len - 1); j >= (i + 1); j--)
			{
				if (comp.compare(data[j], data[j - 1]) > 0)
				{
					tmp = data[j];
					data[j] = data[j - 1];
					data[j - 1] = tmp;
				}
			}
		}
		return data;
	}
}
