package org.se.lab;

public class SorterFactoryImpl
	implements SorterFactory
{
	@Override
	public Sorter createSorter(SortDirection direction)
	{
		switch(direction)
		{
			case ASCENDING: 
				return new BubbleSortAscending();
			
			case DESCENDING: 
				return new BubbleSortDescending();
				
			default: 
				throw new IllegalStateException();
		}
	}
}
