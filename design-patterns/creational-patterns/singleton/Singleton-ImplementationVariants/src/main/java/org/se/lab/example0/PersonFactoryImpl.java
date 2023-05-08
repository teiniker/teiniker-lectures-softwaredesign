package org.se.lab.example0;

public class PersonFactoryImpl
    implements PersonFactory
{

    @Override
    public Person createPerson(int id, String firstName, String lastName, String mail)
    {
        Person p = new Person();
        p.setId(id);
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setMail(mail);
        return p;
    }
}
