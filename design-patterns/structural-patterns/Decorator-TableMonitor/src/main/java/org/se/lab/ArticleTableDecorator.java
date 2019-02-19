package org.se.lab;

import java.util.List;

abstract class ArticleTableDecorator // package private
	implements ArticleTable
{
	/*
	 * Constructor
	 */
	public ArticleTableDecorator(ArticleTable table)
	{
		if(table == null)
			throw new IllegalArgumentException();
		this.table = table;
	}

	/*
	 * Association: ---[1]-> dao:ArticleTable
	 */
	private final ArticleTable table;
	
	
	@Override
	public void insert(Article a)
	{
		table.insert(a);		
	}

	@Override
	public void update(Article a)
	{
		table.update(a);		
	}

	@Override
	public void delete(Article a)
	{
		table.delete(a);		
	}

	@Override
	public Article findById(int id)
	{
		return table.findById(id);
	}

	@Override
	public List<Article> findAll()
	{
		return table.findAll();
	}
}
