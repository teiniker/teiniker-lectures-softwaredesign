package org.se.lab;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ArticleServiceSpyTest
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

		// state verification
		verify(table).insert(captor.capture());
		Article a = captor.getValue();
		Assert.assertEquals(1, a.getId());
		Assert.assertEquals("Effective Java", a.getDescription());
		Assert.assertEquals(3495, a.getPrice());

		// behavioral verification
		verify(table).insert(isA(Article.class));
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

		// state verification
		Assert.assertEquals(3, number);

		// behavioral verification
		verify(table).findAll();
	}
}
