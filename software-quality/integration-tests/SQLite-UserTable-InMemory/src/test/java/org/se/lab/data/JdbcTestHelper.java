package org.se.lab.data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

class JdbcTestHelper
{
	public static final String SQL_STATEMENT_DELIMITER = ";";
	
	private final String driver;
    private final String url;
    private final String user;
    private final String password;
	
    // Constructors

    public JdbcTestHelper()
    {
    	this("jdbc.properties");
    }
    
    public JdbcTestHelper(String propertyFileName) 
    {
    	if(propertyFileName == null || propertyFileName.isEmpty())
    		throw new IllegalArgumentException("Invalid property file name!");
    	    	
        try
		{
        	Properties jdbcProperties = new Properties();
			jdbcProperties.load(new FileInputStream(propertyFileName));
			driver = jdbcProperties.getProperty("jdbc.driver");
			url = jdbcProperties.getProperty("jdbc.url");
			user = jdbcProperties.getProperty("jdbc.username");
			password = jdbcProperties.getProperty("jdbc.password");  
		}
		catch(Exception e)
		{
			throw new IllegalStateException("Unable to load " + propertyFileName + "!");
		}
    }


    // Public Methods

    /**
     * Read a SQL script and execute each SQL statement on the given connection.
     */
    public void executeSqlScript(Connection con, String sqlScriptFileName)
    {
        if(sqlScriptFileName == null || sqlScriptFileName.isEmpty())
            throw new IllegalArgumentException("Invalid SQL script file name!");

        try
        {
            String sqlScript = loadSqlScript(sqlScriptFileName);
            String[] sqlStatements = sqlScript.split(SQL_STATEMENT_DELIMITER);
            try (Statement st = con.createStatement())
			{
                for (String sql : sqlStatements)
				{
                    if (!sql.trim().isEmpty())
					{
                        st.execute(sql.trim());
                    }
                }
            }
        }
        catch(Exception e)
        {
            throw new IllegalStateException("Can't execute SQL script!", e);
        }
    }

	    
    /**
     * Executes a single SQL statement given by a string parameter.
     */
    public void executeSqlStatement(String sqlStatement) 
    {
    	if(sqlStatement == null || sqlStatement.isEmpty())
    		throw new IllegalArgumentException("Invalid SQL statement!");
    	
    	try (Connection con = getConnection(); Statement st = con.createStatement())
    	{
    		st.execute(sqlStatement);
    	}
		catch (SQLException e)
        {
            throw new IllegalStateException("Can't execute SQL statement!" ,e);
        }
    }
    

    /*
     * Utility Methods
     */
    
    
    /**
     * Load an SQL script and eliminate comment lines.
     */
    protected String loadSqlScript(String sqlScriptFileName) 
    {
    	if(sqlScriptFileName == null || sqlScriptFileName.isEmpty())
    		throw new IllegalArgumentException("Invalid SQL script file name!");

		try (BufferedReader in = new BufferedReader(new FileReader(sqlScriptFileName)))
		{
			StringBuilder buffer = new StringBuilder();
			String line;
			while ((line = in.readLine()) != null)
			{
				if (isCommentLine(line))
					continue;
				buffer.append(line.trim());
			}
			in.close();
			return buffer.toString();
		}
		catch (IOException e)
        {
            throw new IllegalStateException("Can't load SQL script", e);
        }
    }
    
    
    /**
     * Check if a given line is a SQL comment.
     */
    protected boolean isCommentLine(String line)
    {
    	if(line == null || line.isEmpty())
    		return false;
    	
    	String comment = line.trim(); 
    	return (comment.startsWith("--") || comment.startsWith("//"));
    }
    
    
    
    /**
     * Establish a JDBC connection to a database as defined by the driver, 
     * url, user and password fields.
     */
    protected Connection getConnection()
    {
		try
		{
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		}
		catch (SQLException | ClassNotFoundException e)
        {
            throw new IllegalStateException("Can't establish connection to the database!", e);
        }
    }

    
    /*
     * Tx handling methods
     */
	
    public void txBegin(Connection c)
    {
		try
		{
			c.setAutoCommit(false);
		}
		catch (SQLException e)
		{
			throw new IllegalStateException("Can't begin transaction!", e);
		}
    }

    public void txCommit(Connection c)
    {
		try
		{
        	c.commit();
        	c.setAutoCommit(true);
		}
		catch (SQLException e)
		{
			throw new IllegalStateException("Can't commit transaction!", e);
		}
	}

    public void txRollback(Connection c)
    {
		try
		{
        	c.rollback();
        	c.setAutoCommit(true);
		}
		catch (SQLException e)
		{
			throw new IllegalStateException("Can't rollback transaction!", e);
		}
	}
}
