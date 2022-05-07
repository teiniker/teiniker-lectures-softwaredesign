package org.se.lab.example1;

import org.se.lab.Person;

public interface PersonFactory
{
    /*
     * Minimal implementation of a Singleton
     */
    PersonFactory INSTANCE  = new PersonFactoryImpl();

    Person createPerson(int id, String firstName, String lastName, String mail);
}

