package org.se.lab;

class ConcreteFactoryPostgresql  // package
    implements AbstractFactory
{
    public PersonTable createPersonTable()
    {
        return new PersonTablePostgresql();
    }

    public ArticleTable createArticleTable()
    {
        return new ArticleTablePostgresql();
    }
}
