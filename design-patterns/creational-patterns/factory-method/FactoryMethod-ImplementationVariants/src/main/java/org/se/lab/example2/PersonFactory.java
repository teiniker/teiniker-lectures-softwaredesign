package org.se.lab.example2;

import org.se.lab.Person;

public interface PersonFactory
{
    default Person createPerson(int id, String firstName, String lastName, String mail)
    {
        Person p = new Person();
        p.setId(id);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setMail(mail);
        return p;
    }
}

