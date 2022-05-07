package org.se.lab;

class ConcreteFactoryHsqldb  // package private
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
