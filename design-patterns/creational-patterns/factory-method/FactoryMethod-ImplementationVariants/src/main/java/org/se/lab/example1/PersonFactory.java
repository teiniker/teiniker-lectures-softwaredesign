package org.se.lab.example1;

import org.se.lab.Person;

public interface PersonFactory
{
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

