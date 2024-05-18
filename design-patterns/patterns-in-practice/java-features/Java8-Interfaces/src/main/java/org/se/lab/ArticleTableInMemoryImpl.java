package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ArticleTableInMemoryImpl
    implements ArticleTable
{
	/*
	 * Simulation of a database table in memory
	 */
	private static List<Article> table = new ArrayList<Article>();
    
    public void insert(Article article)
    {
        if(article == null)
        	throw new IllegalArgumentException();
        table.add(article);
    }


    public Article findById(int id)
    {
        for(Article article : table)
        {
        	if(article.getId() == id)
        		return article;
        }
        return null;
    }

    public List<Article> findAll()
    {
    	List<Article> list = Collections.unmodifiableList(table);
    	delay(2000);	// simulate a long query
        return list; 
    }
    
    private void delay(long millis)
    {
    	try
		{
			Thread.sleep(millis);
		} 
    	catch (InterruptedException e)
		{
    		throw new IllegalStateException("sleep interrupted!", e);
		}
    }
}
