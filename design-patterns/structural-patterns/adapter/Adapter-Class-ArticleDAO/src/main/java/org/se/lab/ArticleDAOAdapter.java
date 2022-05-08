package org.se.lab;

import java.sql.SQLException;

import org.se.lab.legacy.ArticleTable;
import org.se.lab.legacy.LongHolder;
import org.se.lab.legacy.StringHolder;

class ArticleDAOAdapter  // package private
	extends ArticleTable // class Adapter
	implements ArticleDAO
{
	// private ArticleTable table;
	// public ArticleDAOAdapter(ArcticleTable table)
	// 			this.table = table;

	@Override
	public void insert(Article article)
	{	
		try
		{
			// table.save(article.getId(), article.getDescription(), article.getPrice());
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
			// table.load(id, description, price);
			super.load(id, description, price);
			return new Article(id, description.value, price.value);
		}
		catch (SQLException e)
		{
			throw new DAOException("Can't find article!", e);
		}
	}
}
