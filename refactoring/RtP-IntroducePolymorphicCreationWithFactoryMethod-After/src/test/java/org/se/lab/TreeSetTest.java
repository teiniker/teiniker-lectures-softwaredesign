package org.se.lab;


import java.util.Set;
import java.util.TreeSet;


public class TreeSetTest extends AbstractSetTest
{
    @Override
	public Set<String> createSet()
	{
		Set<String> set = new TreeSet<String>();
		return set;
	}
}
