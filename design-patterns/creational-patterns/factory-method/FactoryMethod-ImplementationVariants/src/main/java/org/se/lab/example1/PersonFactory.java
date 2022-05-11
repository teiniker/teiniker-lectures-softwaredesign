package org.se.lab.example2;

import org.se.lab.Person;

public interface PersonFactory
{
    /*
     * Java 8 allows static methods inside interfaces which can be used as creational methods.
     */
    static Person createPerson(int id, String firstName, String lastName, String mail)
    {
        Person p = new Person();
        p.setId(id);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setMail(mail);
        return p;
    }
}

