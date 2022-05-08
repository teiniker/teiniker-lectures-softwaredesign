package org.se.lab;

public class BubbleSortAscendingStrategy
	extends BubbleSort
{
	@Override
	protected boolean compare(int a, int b)
	{
		return a < b;
	}
	
}
