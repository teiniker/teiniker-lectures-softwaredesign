package org.se.lab.example2;

import org.se.lab.Person;

public interface PersonFactory
{
    /*
     * Java 8 introduces a new feature called default methods that allows us to
	 * provide a default implementation for methods in an interface.
     */
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

