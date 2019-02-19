package org.se.lab;

import static java.lang.System.out;

import java.util.List;

class ArticleTableHsqldb
    implements ArticleTable
{
    protected Article article;
    
    public void insert(Article a)
    {
        out.println("hsqldb> insert " + a);
        article = a;
    }

    public void update(Article a)
    {
        out.println("hsqldb> update " + a);
    }

    public void delete(Article a)
    {
        out.println("hsqldb> delete " + a);
    }

    public Article findById(int id)
    {
        out.println("hsqldb> findById " + id);
        return article;
    }

    public List<Article> findAll()
    {
        out.println("hsqldb> findAll ");
        return null;
    }
}
