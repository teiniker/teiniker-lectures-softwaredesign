package org.se.lab;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArticleServiceStubTest
{
	private ArticleTableStub stub;
	private ArticleService service;
	
	@Before
	public void setup()
	{
		stub = new ArticleTableStub();
		service = new ArticleService(stub);
	}
	
	@Test
	public void testAddArticle()
	{
		// setup
		Article book = new Article(1, "Effective Java", 3495);
		
		// exercise
		service.addArticle(book);
		
		// verify
		Article a = stub.articles.get(0);
		Assert.assertEquals(1, a.getId());
		Assert.assertEquals("Effective Java", a.getDescription());
		Assert.assertEquals(3495, a.getPrice());
	}

	@Test
	public void testAddArticleTableException()
	{
		// setup
		stub.exception = new TableException();
		
		// exercise
		try
		{
			service.addArticle(new Article(1, "Effective Java", 3495));
			Assert.fail();
		}
		catch(ServiceException e)
		{
			Assert.assertTrue(e.getCause() instanceof TableException);
		}
	}
	
	@Test
	public void testNumberOfArticles()
	{
		// setup
		stub.articles = Arrays.asList(
				new Article(1, "Effective Java", 3495), 
				new Article(2, "Java Concurrency in Practice", 3895),
				new Article(3, "Clean Code: A Handbook of Agile Software Craftsmanship", 3095)
				);
		 		
		// exercise
		int number = service.numberOfArticles();
		
		// verify
		Assert.assertEquals(3, number);		
	}	
	
	
	@Test
	public void testNumberOfArticlesNullPointerException()
	{
		// setup
		stub.exception = new NullPointerException();
		
		// exercise
		try
		{
			service.numberOfArticles();
			Assert.fail();
		}
		catch(ServiceException e)
		{
			Assert.assertTrue(e.getCause() instanceof NullPointerException);
		}
	}

	public void testNumberOfArticlesTableException()
	{
		// setup
		stub.exception = new TableException();
		
		// exercise
		try
		{
			service.numberOfArticles();
			Assert.fail();
		}
		catch(ServiceException e)
		{
			Assert.assertTrue(e.getCause() instanceof TableException);
		}
	}
}
