package org.se.lab;

public interface ArticleDAO
{
	void insert(Article article);
	
	Article findById(int id);
}
