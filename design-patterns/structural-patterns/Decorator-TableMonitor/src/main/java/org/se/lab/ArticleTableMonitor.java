package org.se.lab;

import java.util.List;
import java.util.logging.Logger;

class ArticleTableMonitor // package private
	extends ArticleTableDecorator
{
	private static Logger logger = Logger.getLogger("org.se.lab");	
	
	/*
	 * Constructor
	 */
	public ArticleTableMonitor(ArticleTable table)
	{
		super(table);
	}
	
	
	@Override
    public List<Article> findAll()
    {
    	long start = System.currentTimeMillis();
    	
    	List<Article> list = super.findAll();	// delegation
    	
        long stop = System.currentTimeMillis();
        logger.info("findAll() duration = " + (stop-start) + "ms");

        return list; 
    }
}
