package org.se.lab;

public interface SorterFactory
{
	BubbleSort createSorter(SortDirection direction);
}
