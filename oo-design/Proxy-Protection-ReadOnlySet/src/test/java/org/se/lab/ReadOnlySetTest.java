package org.se.lab;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;


public class ReadOnlySetTest
	extends AbstractSetTest
{
    @Before
    public void setup()
    {

        Set<Person> s = new HashSet<Person>(); 
        
        s.add(new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"));
        s.add(new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"));

        // Create a read-only proxy
        set = new ReadOnlySet<Person>(s);
    }
    
}
