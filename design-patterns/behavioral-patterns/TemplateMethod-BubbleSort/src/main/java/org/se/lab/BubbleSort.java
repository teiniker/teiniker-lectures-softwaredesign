package org.se.lab;

public abstract class BubbleSort
{
	/*
     * Template Method
     */
	
	public final int[] sort(int... data)
	{
		int len = data.length;
		int tmp = 0;
		for (int i = 0; i < len; i++)
		{
			for (int j = (len - 1); j >= (i + 1); j--)
			{
				if (compare(data[j],  data[j - 1]))
				{
					tmp = data[j];
					data[j] = data[j - 1];
					data[j - 1] = tmp;
				}
			}
		}
		return data;
	}
	
	
	/*
     * Primitive Operation
     */
	
	protected abstract boolean compare(int a, int b);
}
