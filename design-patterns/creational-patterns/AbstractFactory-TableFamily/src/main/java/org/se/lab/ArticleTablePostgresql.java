package org.se.lab;

import static java.lang.System.out;

import java.util.List;

class ArticleTablePostgresql
    implements ArticleTable
{
    protected Article article;
    
    public void insert(Article a)
    {
        out.println("postgresql> insert " + a);
        article = a;
    }

    public void update(Article a)
    {
        out.println("postgresql> update " + a);
    }

    public void delete(Article a)
    {
        out.println("postgresql> delete " + a);
    }

    public Article findById(int id)
    {
        out.println("postgresql> findById " + id);
        return article;
    }

    public List<Article> findAll()
    {
        out.println("postgresql> findAll ");
        return null;
    }
}
