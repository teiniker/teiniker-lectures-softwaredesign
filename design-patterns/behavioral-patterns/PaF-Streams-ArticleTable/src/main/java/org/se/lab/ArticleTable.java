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
		if(article == null)
			throw new IllegalArgumentException("Invalid article!");
		table.add(article);
	}
	
	public void update(Article newArticle)
	{
		table = table.stream().map(a -> a.getId() == newArticle.getId() ? newArticle : a).collect(Collectors.toList());
	}

	
	public void delete(long id)
	{
		table.removeIf(a -> a.getId() == id);
	}
	
	
	public Article findById(long id)
	{
		Optional<Article> result = table.stream().filter(a -> a.getId() == id).findFirst(); 
		return result.orElse(null);
	}
		
	public List<Article> findByDescription(String start)
	{
		return table.stream().filter(a -> a.getDescription().startsWith(start)).collect(Collectors.toList());
	}
		
	public List<Article> findAll()
	{
		return Collections.unmodifiableList(table);
	}

	@Override
	public String toString()
	{
		return "ArticleTable [table=" + table + "]";
	}
}
