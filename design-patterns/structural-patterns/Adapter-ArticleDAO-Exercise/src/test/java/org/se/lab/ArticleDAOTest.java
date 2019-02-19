package org.se.lab;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.legacy.ArticleTable;

public class ArticleDAOTest
{
	private ArticleDAO dao;

	
	@Before
	public void setup() throws SQLException
	{
		dao = new ArticleDAOAdapter(new ArticleTable());
		dao.insert(new Article(7, "GoF Book", 4195));
	}
	
	
	@Test
	public void testFindById()
	{
		Article article = dao.findById(7);
		
		Article expected = new Article(7, "GoF Book", 4195);
		Assert.assertEquals(expected, article);
		Assert.assertTrue(expected.hashCode() == article.hashCode());
		
		Assert.assertEquals("GoF Book", article.getDescription());
		Assert.assertEquals(4195, article.getPrice());
	}

	
	@Test
	public void testFindById_InvalidId() 
	{
		try
		{
			dao.findById(1);
		}
		catch(DAOException e)
		{
			Assert.assertTrue(e.getCause() instanceof SQLException);
		}
	}
}
