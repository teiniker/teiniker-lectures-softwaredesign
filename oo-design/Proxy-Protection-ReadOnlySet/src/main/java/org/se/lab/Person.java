package org.se.lab;

public class Person
{
    /* 
     * Constructor 
     */
    public Person(int id, String firstName, String lastName, String mail)
    {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setMail(mail);
    }
    
    
    /*
     * Property: id
     */
    private int id;
    public final int getId()
    {
        return id;
    }
    public final void setId(final int id)
    {
    	if(id < 0)
    		throw new IllegalArgumentException();
        this.id = id;
    }


    /*
     * Property: firstName
     */
    private String firstName;
    public final String getFirstName()
    {
        return firstName;
    }
    public final void setFirstName(final String firstName)
    {
    	if(firstName == null)
    		throw new IllegalArgumentException("firstName");
    	this.firstName = firstName;
    }

    
    /*
     * Property: lastName
     */
    private String lastName;
    public final String getLastName()
    {
        return lastName;
    }
    public final void setLastName(final String lastName)
    {
    	if(lastName == null)
    		throw new IllegalArgumentException("lastName");
        this.lastName = lastName;
    }

    
    /*
     * Property: mail
     */
    private String mail;
    public final String getMail()
    {
        return mail;
    }
    public final void setMail(final String mail)
    {
    	if(mail == null)
    		throw new IllegalArgumentException("mail");
        this.mail = mail;
    }
    

    /* 
     * Object methods 
     */
    
    public String toString()    
    {
        return getId() + "," + getFirstName() + "," + getLastName() + "," + getMail();
    }
	
    @Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
