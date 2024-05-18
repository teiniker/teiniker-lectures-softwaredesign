package org.se.lab;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArticleTableTest
{
	private ArticleTable table;
	
	@Before
	public void setup()
	{
	    table = ArticleTable.createNewTable();
	    
		table.insert(new Article(1, "The C Programming Language", 2995));
		table.insert(new Article(3, "Practical C Programming", 2295));
		table.insert(new Article(7, "Programming in Objective-C", 4382));
	}
	
	@Test
	public void testFindById()
	{
		Article actual = table.findById(3);
		Article expected = new Article(3, "Practical C Programming", 2295);
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testFindAll()
	{
		List<Article> actual = table.findAll();		
		Assert.assertEquals(3, actual.size());
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testUpdate()
	{
		table.update(new Article(1, "The C Programming Language", 999));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void testDelete()
	{
		table.delete(new Article(1, "The C Programming Language", 2995));
	}
}
