package org.se.lab;


import java.util.HashSet;
import java.util.Set;


public class HashSetTest extends AbstractSetTest
{
    @Override
	public Set<String> createSet()
	{
		Set<String> set = new HashSet<String>();
		return set;
	}
}
