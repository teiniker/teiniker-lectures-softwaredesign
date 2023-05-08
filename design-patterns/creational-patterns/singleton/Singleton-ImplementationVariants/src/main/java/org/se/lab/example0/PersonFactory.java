package org.se.lab.example0;

public interface PersonFactory
{
    /*
     * Minimal implementation of a Singleton
     */
    PersonFactory INSTANCE  = new PersonFactoryImpl();

    Person createPerson(int id, String firstName, String lastName, String mail);
}

