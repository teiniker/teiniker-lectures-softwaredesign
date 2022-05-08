package org.se.lab;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.legacy.ArticleTable;
import org.se.lab.legacy.LongHolder;
import org.se.lab.legacy.StringHolder;

public class ArticleTableTest
{
	private ArticleTable table;

	
	@Before
	public void setup() throws SQLException
	{
		table = new ArticleTable();
		table.save(7, "GoF Book", 4195);
	}
	
	@Test
	public void testLoad() throws SQLException
	{
		StringHolder description = new StringHolder();
		LongHolder price = new LongHolder();
		table.load(7, description, price);
		
		Assert.assertEquals("GoF Book", description.value);
		Assert.assertEquals(4195, price.value);
	}

	@Test(expected = SQLException.class)
	public void testLoad_InvalidId() throws SQLException
	{
		StringHolder description = new StringHolder();
		LongHolder price = new LongHolder();
		table.load(1, description, price);

	}
	
}
