package org.se.lab;

import java.util.List;
import java.util.logging.Logger;

public class ArticleTableLogger
	extends ArticleTableDecorator
{
	private static Logger logger = Logger.getLogger("org.se.lab");	
	
	/*
	 * Constructor
	 */
	public ArticleTableLogger(ArticleTable dao)
	{
		super(dao);
	}
	
	public void insert(Article article)
    {
    	// logging
    	logger.info("insert() article=" + article);

    	// delegation
    	super.insert(article);
    }

    public Article findById(int id)
    {
    	// logging
    	logger.info("findById() id=" + id);
    	
    	// delegation
    	return super.findById(id);
    }
    
    
    public List<Article> findAll()
    {
    	// logging
    	logger.info("findAll()");
    	
    	// delegation
    	return super.findAll();
    }
}
