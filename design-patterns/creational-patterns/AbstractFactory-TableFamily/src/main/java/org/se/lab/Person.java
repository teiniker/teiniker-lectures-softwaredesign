package org.se.lab;

public class Person
{
    private int id;
    private String firstName;
    private String lastName;
    private String mail;
    
    public Person(int id, String firstName, String lastName, String mail)
    {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }

    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getMail()
    {
        return mail;
    }
    public void setMail(String mail)
    {
        this.mail = mail;
    }
}
