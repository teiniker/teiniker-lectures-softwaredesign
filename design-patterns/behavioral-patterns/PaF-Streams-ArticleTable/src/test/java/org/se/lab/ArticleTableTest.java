package org.se.lab;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ArticleTableTest
{
	private ArticleTable table;
	
	@Before
	public void setup()
	{
		table = new ArticleTable();
		
		table.insert(new Article(1, "Pizza Margherita"));
		table.insert(new Article(3, "Pizza Romana"));
		table.insert(new Article(5, "Pizza Capricciosa"));
		table.insert(new Article(7, "Beer"));
		table.insert(new Article(11, "Wine"));
	}
	
	
	@Test
	public void testFindAll()
	{
		List<Article> results = table.findAll();
		Assert.assertEquals(5, results.size());
	}
		
	@Test
	public void testFindById()
	{
		Assert.assertEquals("Pizza Margherita", table.findById(1).getDescription());
		Assert.assertEquals("Pizza Romana", table.findById(3).getDescription());
		Assert.assertEquals("Pizza Capricciosa", table.findById(5).getDescription());
		Assert.assertNull(table.findById(666));
	}
	
	@Test
	public void testFindByDescription()
	{
		Assert.assertEquals(3, table.findByDescription("Pizza").size());
		Assert.assertEquals(1, table.findByDescription("Beer").size());	
	}
	
	@Test
	public void testDelete()
	{
		table.delete(3);
		table.delete(5);
		
		Assert.assertEquals(3, table.findAll().size());
		System.out.println(table);
	}

	@Test
	public void testUpdate()
	{
		table.update(new Article(3, "Pizza Siciliana"));
		System.out.println(table);
	}

}
