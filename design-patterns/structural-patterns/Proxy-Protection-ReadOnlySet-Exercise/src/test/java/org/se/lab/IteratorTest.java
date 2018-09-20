package org.se.lab;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IteratorTest
{
	private Iterator<Person> it;
	
    @Before
    public void setup()
    {

        Set<Person> s = new HashSet<Person>(); 
        
        s.add(new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"));
        s.add(new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"));

        // Create a read-only proxy for Set<E> and Iterator<E>
        Set<Person> set = new ReadOnlySet<Person>(s);
        it = set.iterator();
    }
    
    @Test
    public void testHasNextAndNext()
    {
    	Assert.assertTrue(it.hasNext());
    	Assert.assertEquals(new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"), it.next());

    	Assert.assertTrue(it.hasNext());
    	Assert.assertEquals(new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"), it.next());    	
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testRemove()
    {
    	it.remove();
    }
}
