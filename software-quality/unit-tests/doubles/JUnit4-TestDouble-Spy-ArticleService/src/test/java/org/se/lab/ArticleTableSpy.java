package org.se.lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleTableSpy 
	implements ArticleTable
{
	/*
	 * Association: ---[1]-> ArticleTable
	 */
	private ArticleTable table;
	
	/*
	 * Constructor
	 */
	public ArticleTableSpy(ArticleTable table)
	{
		if(table == null)
			throw new IllegalArgumentException();
		this.table = table;
	}
	
	/*
	 * Log-List
	 */
	protected List<String> logs = new ArrayList<>();
	protected void log(String s)
	{
		Date now = new Date();
		logs.add(now.getTime() + ": " + s);
	}
	
	// Interface methods
	
	@Override
	public void insert(Article article)
	{
		log("ArticleTable.insert(" + article + ")");
		table.insert(article);
	}

	@Override
	public void update(Article p)
	{
	}

	@Override
	public void delete(int id)
	{
	}

	@Override
	public Article findById(int id)
	{
		return null;
	}

	@Override
	public List<Article> findAll()
	{
		log("ArticleTable.findAll()");

		List<Article> articles = table.findAll();
		return articles;
	}
}
