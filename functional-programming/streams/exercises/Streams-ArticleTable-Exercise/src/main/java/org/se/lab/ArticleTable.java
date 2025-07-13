package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArticleTable
{
	private List<Article> table = new ArrayList<>();
	
	public void insert(Article article)
	{
		// TODO
	}
	
	public void update(Article newArticle)
	{
		// TODO
	}

	public void delete(long id)
	{
		// TODO
	}

	public Article findById(long id)
	{
		// TODO
	}
		
	public List<Article> findByDescription(String start)
	{
		// TODO
	}
		
	public List<Article> findAll()
	{
		// TODO
	}

	@Override
	public String toString()
	{
		return "ArticleTable [table=" + table + "]";
	}
}
