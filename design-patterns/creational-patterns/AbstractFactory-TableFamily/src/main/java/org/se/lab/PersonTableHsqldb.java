package org.se.lab;

import static java.lang.System.out;

import java.util.List;

class PersonTableHsqldb
    implements PersonTable
{
    protected Person person;
    
    public void insert(Person p)
    {
        out.println("hsqldb> insert " + p);
        person = p;
    }

    public void update(Person p)
    {
        out.println("hsqldb> update " + p);
    }

    public void delete(Person p)
    {
        out.println("hsqldb> delete " + p);
    }

    public Person findById(int id)
    {
        out.println("hsqldb> findById " + id);
        return person;
    }

    public List<Person> findAll()
    {
        out.println("hsqldb> findAll ");
        return null;
    }
}
