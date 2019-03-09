package org.se.lab;

import java.sql.SQLException;

import org.se.lab.legacy.ArticleTable;
import org.se.lab.legacy.LongHolder;
import org.se.lab.legacy.StringHolder;

public class ArticleDAOAdapter
	extends ArticleTable
	implements ArticleDAO
{
	@Override
	public void insert(Article article)
	{	
		try
		{
			super.save(article.getId(), article.getDescription(), article.getPrice());
		}
		catch (SQLException e)
		{
			throw new DAOException("Can't insert article!", e);
		}
	}

	@Override
	public Article findById(int id)
	{
		StringHolder description = new StringHolder();
		LongHolder price = new LongHolder();
		try
		{
			super.load(id, description, price);
			return new Article(id, description.value, price.value);
		}
		catch (SQLException e)
		{
			throw new DAOException("Can't find article!", e);
		}
	}
}
