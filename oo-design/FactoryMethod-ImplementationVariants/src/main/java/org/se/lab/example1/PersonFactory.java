package org.se.lab.example1;

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

    PersonFactory INSTANCE  = new PersonFactoryImpl();

    /*
     * Java 8 introduces a new feature called default methods that allows us to
	 * provide a default implementation for methods in an interface.
     */
    default Person newPerson(int id, String firstName, String lastName, String mail)
    {
        return PersonFactory.createPerson(id, firstName, lastName, mail);
    }
}

