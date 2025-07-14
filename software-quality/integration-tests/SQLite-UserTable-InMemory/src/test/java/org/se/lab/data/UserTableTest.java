package org.se.lab.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTableTest
{	
	private static final JdbcTestHelper JDBC_HELPER = new JdbcTestHelper("src/test/resources/jdbc.properties");
	private Connection connection = null;
	private UserTable table;
	
	@Before
	public void setup()
	{
		connection = JDBC_HELPER.getConnection();
		JDBC_HELPER.executeSqlScript(connection, "src/test/resources/sql/setup.sql");
		table = new UserTableImpl(connection);
	}
	
	@After
	public void teardown() throws SQLException
	{
		JDBC_HELPER.executeSqlScript(connection, "src/test/resources/sql/teardown.sql");
		connection.close();
	}

	@Test
    public void testFindById() 
	{
		User user = table.findById(2);
        
		Assert.assertEquals("Bart", user.getFirstname());
		Assert.assertEquals("Simpson", user.getLastname());
        Assert.assertEquals("bart", user.getUsername());
        Assert.assertEquals("VUb+dKJUIzdDfdjILoJdsOqQYYXSs4RXbH0WgUL1ZXw=", user.getPassword());
    }

	
	@Test
    public void testFindAll() 
	{
		List<User> users = table.findAll();
        
        Assert.assertEquals(3, users.size());
        Assert.assertEquals("homer", users.get(0).getUsername());
        Assert.assertEquals("bart", users.get(1).getUsername());
        Assert.assertEquals("lisa", users.get(2).getUsername());
    }
	
	
	@Test
	public void testInsert()
	{
		table.createUser("Marge", "Simpson", "marge", "tLgR+kBQUymuhx5S8DUnw3IMmvf7hgeBllhTXFSExB4=");
		
		User result = table.findById(4);
		Assert.assertEquals("marge", result.getUsername());
	}
}
