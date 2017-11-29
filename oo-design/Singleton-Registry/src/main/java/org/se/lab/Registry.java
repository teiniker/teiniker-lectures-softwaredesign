package org.se.lab;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Registry
{
	private final static String PROPERTY_FILE_NAME = "jdbc.properties";
	
	private final String driver;
    private final String url;
    private final String username;
    private final String password;  

    
	/*
	 * Singleton Pattern
	 */
	private final static Registry INSTANCE = new Registry();
	public static Registry getInstance()
	{
		return INSTANCE;
	}
	
	private Registry() 
	{
    	Properties jdbcProperties = new Properties();
		try
		{
			jdbcProperties.load(new FileInputStream(PROPERTY_FILE_NAME));
			driver = jdbcProperties.getProperty("jdbc.driver");
			url = jdbcProperties.getProperty("jdbc.url");
			username = jdbcProperties.getProperty("jdbc.username");
			password = jdbcProperties.getProperty("jdbc.password");  
		} 
		catch (IOException e)
		{
			throw new IllegalStateException(e);
		} 
	}
	
	
	/*
	 * Operations
	 */
	
	public String getJdbcDriver()
	{
		return driver;
	}
	
	public String getJdbcUrl()
	{
		return url;
	}
	
	public String getJdbcUsername()
	{
		return username;
	}

	public String getJdbcPassword()
	{
		return password;
	}
	
	public Connection getJdbcConnection()
	{
		// TODO
		return null; 
	}
}
