package org.se.lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PropertiesTest
{
	private final static String PROPERTY_FILE_NAME = "jdbc.properties";
	
	private String driver;
    private String url;
    private String username;
    private String password;  
    
    
    @Before
    public void setup() throws FileNotFoundException, IOException
    {
    	Properties jdbcProperties = new Properties();
    	jdbcProperties.load(new FileInputStream(PROPERTY_FILE_NAME));
    	driver = jdbcProperties.getProperty("jdbc.driver");
    	url = jdbcProperties.getProperty("jdbc.url");
    	username = jdbcProperties.getProperty("jdbc.username");
    	password = jdbcProperties.getProperty("jdbc.password");      	
    }
    
    
	@Test
	public void testProperties()
	{
		Assert.assertEquals("com.mysql.jdbc.Driver", driver);
		Assert.assertEquals("jdbc:mysql://localhost:3306/testdb", url);
		Assert.assertEquals("admin", username);
		Assert.assertEquals("*******", password);
	}
}
