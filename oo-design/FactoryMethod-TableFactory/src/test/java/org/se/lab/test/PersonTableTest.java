package org.se.lab.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.TableFactory;
import org.se.lab.Person;
import org.se.lab.PersonTable;


public class PersonTableTest
{
	private TableFactory factory;
	@Before
	public void setup()
	{
//    	TableFactory f = new TableFactoryImpl(); // unknown TableFactoryImpl
		factory = TableFactory.INSTANCE;
	}
	
	
    @Test
    public void testFindById()
    {
//    	PersonTable table = new PersonTableImpl(); // unknown PersonTableImpl
    	 
    	PersonTable table = factory.createPersonTable();
        table.insert(new Person(7, "Franz", "Kafka", "fk@history.at"));
        
        Person p = table.findById(7);
        assertEquals(p.getId(), 7);
        assertEquals(p.getFirstName(), "Franz");
        assertEquals(p.getLastName(), "Kafka");
        assertEquals(p.getMail(), "fk@history.at");
    }
    
    @Test
    public void testFindAll()
    {
    	PersonTable table = factory.createPersonTable();
        table.insert(new Person(7, "Franz", "Kafka", "fk@history.at"));
        table.insert(new Person(11, "Karl", "Kraus", "kk@history.at"));
        
        List<Person> list = table.findAll();
        Assert.assertEquals(2, list.size());
        Assert.assertEquals(new Person(7, "Franz", "Kafka", "fk@history.at"), list.get(0));
        Assert.assertEquals(new Person(11, "Karl", "Kraus", "kk@history.at"), list.get(1));
    }
}
