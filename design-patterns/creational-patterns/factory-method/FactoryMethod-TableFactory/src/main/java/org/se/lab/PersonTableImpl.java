package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class PersonTableImpl  // package private
    implements PersonTable
{
	/*
	 * Simulate a database table with an in-memory list
	 */
    protected List<Person> table = new ArrayList<Person>();
    
       
    public void insert(Person person)
    {
    	if(person == null)
    		throw new IllegalArgumentException();
        table.add(person);
    }

    public void update(Person p)
    {
    	// not implemented
    }

    public void delete(Person p)
    {
        // not implemented
    }

    public Person findById(int id)
    {
        for(Person p : table)
        {
        	if(p.getId() == id)
        		return p;
        }
        return null; // no Person with that id in the table!
    }

    public List<Person> findAll()
    {       
        return Collections.unmodifiableList(table);
    }
}
