package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest
{

    @Test
    public void testSoleInstance()
    {
//    	Registry registry = new Registry(); // Constructor is not visible!!
        
    	Registry firstInstance = Registry.getInstance();
        Registry secondInstance = Registry.getInstance();
        
        assertTrue(firstInstance == secondInstance);

        out.println("first instance = " + firstInstance);
        out.println("second instance= " + secondInstance);
    }

	@Test
	public void testJdbcProperties()
	{
		Assert.assertEquals("com.mysql.jdbc.Driver", Registry.getInstance().getJdbcDriver());
		Assert.assertEquals("jdbc:mysql://localhost:3306/testdb", Registry.getInstance().getJdbcUrl());
		Assert.assertEquals("admin", Registry.getInstance().getJdbcUsername());
		Assert.assertEquals("*******", Registry.getInstance().getJdbcPassword());
	}
}
