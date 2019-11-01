package org.se.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.Test;

public class StreamTerminalOperationTest
{
	private List<String> list = Arrays.asList("eins", "zwei", "drei", "vier", "fünf"); 
	
	@Test
	public void testCollect()
	{
		// The collect() method accepts an argument of the type Collector. 
		// There are already created predefined Collectors.
		Set<String> set = list.stream().map(String::toUpperCase).collect(Collectors.toSet());
		
		set.forEach(System.out::println);
	}

	@Test
	public void testJoining()
	{
		// The joining() method can have from one to three parameters (delimiter, prefix, suffix)
		String s = list.stream().map(String::toUpperCase).collect(Collectors.joining(",", "[", "]"));
		
		System.out.println(s);
	}

	@Test
	public void testCount()
	{
		// Count the elements in this stream.
		long number = list.stream().map(String::toUpperCase).count();
		
		System.out.println(number);
	}
}
