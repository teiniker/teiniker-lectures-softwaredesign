package org.se.lab;

class ConcreteFactoryHsqldb
    implements AbstractFactory
{
    public PersonTable createPersonTable()
    {
        return new PersonTableHsqldb();
    }

    public ArticleTable createArticleTable()
    {
        return new ArticleTableHsqldb();
    }
}
