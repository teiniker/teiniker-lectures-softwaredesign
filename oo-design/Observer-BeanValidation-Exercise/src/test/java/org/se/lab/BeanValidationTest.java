package org.se.lab;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.Bean;


public class BeanValidationTest
{
	private Bean element;
	
	@Before
	public void setup()
	{
		element = new Bean(7,"Entity");
		// Register an observer which checks state changes.
		element.add(new BeanValidationObserver());		
	}
	
	@Test
	public void testModelElement()
	{		
		element.setName("Entity");
		element.setId(1);
	}

	@Test(expected = IllegalStateException.class)
	public void testNameNull()
	{		
		element.setName(null);		
	}

	@Test(expected = IllegalStateException.class)
	public void testNameNullTooShort()
	{		
		element.setName("123");		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testNameNullTooLong()
	{		
		element.setName("123456789012345678901234567890123");		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testIdNegative()
	{		
		element.setId(-1);		
	}
}
