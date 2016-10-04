package org.se.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractSetTest
{
	protected Set<Person> set;
	
    @Test
    public void testSize()
    {
        Assert.assertEquals(2, set.size());
    }
    
    @Test
    public void testIsEmpty()
    {
        Assert.assertFalse(set.isEmpty());
    }

    @Test
    public void testContains()
    {
    	Person p = new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at");
    	Assert.assertTrue(set.contains(p));
    }
    
    @Test
    public void testToArray()
    {
    	Object[] result = set.toArray();
    	
    	Assert.assertEquals(result[0], new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"));
    	Assert.assertEquals(result[1], new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"));
    }
    
    @Test
    public void testToArray2()
    {
    	Person[] result = set.toArray(new Person[set.size()]);
    	
    	Assert.assertEquals(result[0], new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"));
    	Assert.assertEquals(result[1], new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"));
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testAdd()
    {
    	set.add(new Person(13, "Gerhard", "Roth", "gerhard.roth@fhj.at"));        
    }
        
    @Test(expected=UnsupportedOperationException.class)
    public void testRemove()
    {
        set.remove(0);
    }
    
    @Test
    public void testContainsAll()
    {
    	List<Person> list = Arrays.asList(
    			new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"),
    			new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"));
    	
    	Assert.assertTrue(set.containsAll(list));
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testAddAll()
    {
    	List<Person> list = Arrays.asList(
    			new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"),
    			new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"));
    	
    	set.addAll(list);
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testRetainAll()
    {
    	List<Person> list = Arrays.asList(
    			new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"),
    			new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"));
    	
    	set.retainAll(list);
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testRemoveAll()
    {
    	List<Person> list = Arrays.asList(
    			new Person(1, "Franz", "Kafka", "franz.kafka@fhj.at"),
    			new Person(7, "Karl", "Kraus", "karl.kraus@fhj.at"));
    	
    	set.removeAll(list);
    }
    
    @Test(expected=UnsupportedOperationException.class)
    public void testClear()
    {
    	set.clear();
    }    
}
