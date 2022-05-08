package org.se.lab;

import java.util.List;

public interface ArticleTable
{
    void insert(Article a);
    void update(Article a);
    void delete(Article a);
    
    Article findById(int id);
    List<Article> findAll();
}
