package org.se.lab;

import java.util.List;

public class ArticleService
{
	/*
	 * Constructor
	 */
	public ArticleService(ArticleTable table)
	{
		if(table == null)
			throw new IllegalArgumentException();
	
		this.table = table;
	}
	
	/*
	 * Association: ---[1]-> table:ArticleTable
	 */
	private ArticleTable table;
	
	
	
	public void addArticle(Article article)
	{
		try
		{
			table.insert(article);
		}
		catch(TableException e)
		{
			throw new ServiceException(e);
		}
	}
	
	public int numberOfArticles()
	{
		try
		{
			List<Article> articles = table.findAll();
			return articles.size();
			
		}
		catch(TableException e)
		{
			throw new ServiceException(e);
		}
		catch(NullPointerException e)
		{
			throw new ServiceException(e);
		}
	}
	
	// ...
}
