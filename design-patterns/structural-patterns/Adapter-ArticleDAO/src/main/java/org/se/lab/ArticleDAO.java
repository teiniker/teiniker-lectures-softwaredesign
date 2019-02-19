package org.se.lab;

/*
 * 1 Punkt
 */
public interface ArticleDAO
{
	void insert(Article article);
	
	Article findById(int id);
}
