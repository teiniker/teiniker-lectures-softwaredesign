package org.se.lab;

import static java.lang.System.out;

import java.util.List;

class PersonTablePostgresql
	implements PersonTable
//    extends PersonTableHsqldb
{
	private Person person;
	
    public void insert(Person p)
    {
        out.println("postgresql> insert " + p);
        person = p;
    }

    public void update(Person p)
    {
        out.println("postgresql> update " + p);
    }

    public void delete(Person p)
    {
        out.println("postgresql> delete " + p);
    }

    public Person findById(int id)
    {
        out.println("postgresql> findById " + id);
        return person;
    }

    public List<Person> findAll()
    {
        out.println("postgresql> findAll ");
        return null;
    }
}
