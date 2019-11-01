package org.se.lab;

import java.util.List;

public interface ArticleTable
{
    void insert(Article a);
   
    default void update(Article a)
    {
    	throw new UnsupportedOperationException();
    }
    
    default void delete(Article a)
    {
    	throw new UnsupportedOperationException();
    }
        
    Article findById(int id);
    
    List<Article> findAll();
    
    
    static ArticleTable createNewTable()
    {
        return new ArticleTableInMemoryImpl();
    }
}
