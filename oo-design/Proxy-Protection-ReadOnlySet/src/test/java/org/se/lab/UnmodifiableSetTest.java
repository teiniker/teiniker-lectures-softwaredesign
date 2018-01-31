package org.se.lab;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;


public class UnmodifiableSetTest
	extends AbstractSetTest
{
    @Before
    public void setup()
    {

        Set<Person> s = new HashSet<Person>(); 
        
        s.add(new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"));
        s.add(new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"));

        // Create a read-only proxy
        set = Collections.unmodifiableSet(s);
    }
    
}
