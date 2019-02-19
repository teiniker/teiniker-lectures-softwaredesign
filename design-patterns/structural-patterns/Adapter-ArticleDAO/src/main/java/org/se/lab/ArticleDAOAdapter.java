package org.se.lab;

import java.sql.SQLException;

import org.se.lab.legacy.ArticleTable;
import org.se.lab.legacy.LongHolder;
import org.se.lab.legacy.StringHolder;

public class ArticleDAOAdapter
	implements ArticleDAO
{
	/*
	 * Constructor injection
	 */
	private ArticleTable table;
	public ArticleDAOAdapter(ArticleTable table)
	{
		if(table == null)
			throw new IllegalArgumentException();
		this.table = table;
	}
	
	/*
	 * 3 Punkte
	 */	
	@Override
	public void insert(Article article)
	{	
		try
		{
			table.save(article.getId(), article.getDescription(), article.getPrice());
		}
		catch (SQLException e)
		{
			throw new DAOException("Can't insert article!", e);
		}
	}

	/*
	 * 3 Punkte
	 */
	@Override
	public Article findById(int id)
	{
		StringHolder description = new StringHolder();
		LongHolder price = new LongHolder();
		try
		{
			table.load(id, description, price);			
			return new Article(id, description.value, price.value);
		}
		catch (SQLException e)
		{
			throw new DAOException("Can't find article!", e);
		}
	}
}
