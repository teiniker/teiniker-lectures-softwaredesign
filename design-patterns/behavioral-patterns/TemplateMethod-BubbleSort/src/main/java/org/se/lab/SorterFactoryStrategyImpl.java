package org.se.lab;

public class SorterFactoryStrategyImpl
	implements SorterFactory
{
	@Override
	public BubbleSort createSorter(SortDirection direction)
	{
		switch(direction)
		{
			case ASCENDING: 
				return new BubbleSortAscendingStrategy();
			
			case DESCENDING: 
				return new BubbleSortDescendingStrategy();
				
			default: 
				throw new IllegalStateException();
		}
	}
}
