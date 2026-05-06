package org.se.lab;

import java.util.List;

public interface ArticleTable
{
    void insert(Article p);
    void update(Article p);
    void delete(int id);
    
    Article findById(int id);
    List<Article> findAll();
}
