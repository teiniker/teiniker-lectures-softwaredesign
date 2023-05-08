package org.se.lab.example0;

public class Person
{
    public Person()
    {
        this(0,"","","");
    }

    public Person(int id, String firstName, String lastName, String mail)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
    }

    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String mail;
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + mail;
    }
}
