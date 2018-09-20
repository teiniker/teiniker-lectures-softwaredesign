package org.se.lab;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;

public class VirtualTextFileTest
	extends AbstractTextFileTest
{
	@Before
	public void setup() 
	{
		file = new VirtualTextFile("SympathyForTheDevil.txt");
		
		// A virtual proxy doesn't creates the impl object before
		// the first operation invocation. Thererfore, we check if impl is null. 
		assertPrivateFieldNull(file, "impl");
	}
	
	
	private void assertPrivateFieldNull(Object obj, String fieldname)
	{		
		try
		{
			Field impl = obj.getClass().getDeclaredField("impl");
			impl.setAccessible(true);		
			Assert.assertNull(impl.get(file));
		} 
		catch (Exception e)
		{
			Assert.fail(e.getMessage());
		} 
	}
}
