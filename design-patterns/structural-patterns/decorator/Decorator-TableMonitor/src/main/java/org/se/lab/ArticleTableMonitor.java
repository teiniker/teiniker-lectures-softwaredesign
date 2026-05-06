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
		// pre-processing
    	long start = System.currentTimeMillis();
    	
		// delegation
    	List<Article> list = super.findAll();
    	
		// post-processing
        long stop = System.currentTimeMillis();
        logger.info("findAll() duration = " + (stop-start) + "ms");

        return list; 
    }
}
