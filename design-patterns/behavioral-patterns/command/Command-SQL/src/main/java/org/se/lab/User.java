package org.se.lab;


public class User
    implements Comparable<User>
{
    /* 
     * Constructor 
     */    
    public User(int id, String username, String password)   
	{
		setId(id);
		setUsername(username);
		setPassword(password);
	}
	
    
	/*
	 * Property: id
	 */
    private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	
	/*
	 * Property: username
	 */
    private String username;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		if(username == null)
			throw new NullPointerException();
		this.username = username;
	}

	
	/*
	 * Property: password
	 */
    private String password;
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		if(password == null)
			throw new NullPointerException();
		this.password = password;
	}
	
	
	/*
	 * Object methods
	 */
		
	@Override
	public String toString()
	{
		return getId() + "," + getUsername() + "," + getPassword();
	}
	

	@Override
    public int compareTo(User target)
    {
        System.out.println("compareTo()");
        if(getId() > target.getId())
            return 1;
        if(getId() < target.getId())
            return -1;
        return 0;
    }
	
    @Override
    public int hashCode()
    {
    	System.out.println("hashCode()");
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    
    @Override
    public boolean equals(Object obj)
    {
    	System.out.println("equals()");
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }	
}
