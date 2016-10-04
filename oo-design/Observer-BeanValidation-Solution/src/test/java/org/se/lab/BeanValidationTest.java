package org.se.lab;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.Bean;
import org.se.lab.BeanValidationObserver;


public class BeanValidationTest
{
	private Bean bean;
	
	@Before
	public void setup()
	{
		bean = new Bean(7,"Entity");
		// Register an observer which checks state changes.
		bean.addObserver(new BeanValidationObserver());		
	}
	
	@Test
	public void testModelElement()
	{		
		bean.setName("Entity");
		bean.setId(1);
	}

	@Test(expected = IllegalStateException.class)
	public void testNameNull()
	{		
		bean.setName(null);		
	}

	@Test(expected = IllegalStateException.class)
	public void testNameNullTooShort()
	{		
		bean.setName("123");		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testNameNullTooLong()
	{		
		bean.setName("123456789012345678901234567890123");		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testIdNegative()
	{		
		bean.setId(-1);		
	}
}
