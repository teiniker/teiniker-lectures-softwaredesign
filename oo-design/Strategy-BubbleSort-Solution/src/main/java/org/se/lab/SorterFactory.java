package org.se.lab;

public interface SorterFactory
{
	Sorter createSorter(SortDirection direction);
}
