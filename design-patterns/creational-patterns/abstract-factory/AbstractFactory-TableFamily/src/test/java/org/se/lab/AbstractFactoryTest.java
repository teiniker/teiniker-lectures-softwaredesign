package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.AbstractFactory;
import org.se.lab.Article;
import org.se.lab.ArticleTable;
import org.se.lab.Person;
import org.se.lab.PersonTable;


public class AbstractFactoryTest
{    
    @Before
    public void setUp()
    {
//        Factory factory = new FactoryHsqldb(); // is not visible!!!
//        Factory factory = new FactoryPostgresql(); // is not visible!!!        
    }
    
    
    @Test
    public void testConcreteFactoryHsqldb()
    {
        // Use concrete factory 1 (Hsqldb Table family)
        AbstractFactory factory = AbstractFactory.HSQLDB;
        
        // Use product A
        PersonTable personTable = factory.createPersonTable();        
        personTable.insert(new Person(7, "Franz", "Kafka", "fk@fhj.at"));
        assertEquals(personTable.findById(7).getFirstName(), "Franz");
        
        // Use product B
        ArticleTable articleTable = factory.createArticleTable();
        articleTable.insert(new Article(3, "GoF Book", 34.80));
        assertEquals(articleTable.findById(3).getDescription(), "GoF Book");
    }

    @Test
    public void testConcreteFactoryPostgreSQL()
    {
        // Use concrete factory 2 (PostgreSQL Table family)
        AbstractFactory factory = AbstractFactory.POSTGRESQL;

        // Use product A        
        PersonTable personTable = factory.createPersonTable();        
        personTable.insert(new Person(7, "Franz", "Kafka", "fk@fhj.at"));
        assertEquals(personTable.findById(7).getFirstName(), "Franz");

        // Use product B        
        ArticleTable articleTable = factory.createArticleTable();
        articleTable.insert(new Article(3, "GoF Book", 34.80));
        assertEquals(articleTable.findById(3).getDescription(), "GoF Book");
    }
}
