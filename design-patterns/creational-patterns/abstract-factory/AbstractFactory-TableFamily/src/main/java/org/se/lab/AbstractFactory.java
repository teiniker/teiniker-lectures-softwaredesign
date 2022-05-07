package org.se.lab;

/**
 * Abstract factory.
 */
public interface AbstractFactory
{
    // This is a minimal implementation of a singleton pattern.
    final AbstractFactory HSQLDB = new ConcreteFactoryHsqldb();    
    final AbstractFactory POSTGRESQL = new ConcreteFactoryPostgresql();
    
//    final AbstractFactory INSTANCE = new ConcreteFactoryHsqldb(); 
    
    // Factory methods
    PersonTable createPersonTable();
    ArticleTable createArticleTable();
    // ...
}
