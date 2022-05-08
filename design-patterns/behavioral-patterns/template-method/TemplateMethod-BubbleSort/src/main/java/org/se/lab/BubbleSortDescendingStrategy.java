package org.se.lab;

public class BubbleSortDescendingStrategy
	extends BubbleSort
{
	@Override
	protected boolean compare(int a, int b)
	{
		return a > b;
	}
}
