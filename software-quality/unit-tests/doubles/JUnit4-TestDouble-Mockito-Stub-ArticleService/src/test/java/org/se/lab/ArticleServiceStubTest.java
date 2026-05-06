package org.se.lab;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ArticleServiceStubTest
{
	private ArticleTable table;
	private ArticleService service;

	@Before
	public void setup()
	{
		table = Mockito.mock(ArticleTable.class);
		service = new ArticleService(table);
	}

	@Test
	public void testAddArticle()
	{
		// setup
		Article book = new Article(1, "Effective Java", 3495);
		ArgumentCaptor<Article> captor = ArgumentCaptor.forClass(Article.class);

		// exercise
		service.addArticle(book);

		// verify
		verify(table).insert(captor.capture());
		Article a = captor.getValue();
		Assert.assertEquals(1, a.getId());
		Assert.assertEquals("Effective Java", a.getDescription());
		Assert.assertEquals(3495, a.getPrice());
	}

	@Test
	public void testAddArticleTableException()
	{
		// setup
		doThrow(TableException.class).when(table).insert(isA(Article.class));

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
		when(table.findAll()).thenReturn(Arrays.asList(
				new Article(1, "Effective Java", 3495),
				new Article(2, "Java Concurrency in Practice", 3895),
				new Article(3, "Clean Code: A Handbook of Agile Software Craftsmanship", 3095)
		));

		// exercise
		int number = service.numberOfArticles();

		// verify
		Assert.assertEquals(3, number);
	}

	@Test
	public void testNumberOfArticlesNullPointerException()
	{
		// setup
		when(table.findAll()).thenThrow(NullPointerException.class);

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

	@Test
	public void testNumberOfArticlesTableException()
	{
		// setup
		when(table.findAll()).thenThrow(TableException.class);

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
