package org.se.lab;

import java.util.List;

public interface PersonTable
{
    void insert(Person p);
    void update(Person p);
    void delete(Person p);
    
    Person findById(int id);
    List<Person> findAll();
}
