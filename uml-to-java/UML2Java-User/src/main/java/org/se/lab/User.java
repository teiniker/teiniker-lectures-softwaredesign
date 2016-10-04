package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class User
    implements Comparable<User>
{
    /*
     * Constrcutor
     */
    public User(long id, String username, String password)
    {
        setId(id);
        setUsername(username);
        setPassword(password);
    }
    
        
    /*
     * Property: id:long
     */
    private long id;
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }


    /*
     * Property: username:String
     */
    private String username;
    public String getUsername()
    {
        return username;
    }
    public void setUsername(String username)
    {
        if(username == null)
            throw new IllegalArgumentException("Invalid username!");
        this.username = username;
    }


    /*    
     * Property: password:String
     */
    private String password;
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        if(password == null)
            throw new IllegalArgumentException("Invalid password!");
        this.password = password;
    }

    /*
     * Association: ---[*]-> EMail
     */
    private List<EMail> mails = new ArrayList<>();    
    public List<EMail> getMails()
    {
        return mails;
    }
    public void setMails(List<EMail> mails)
    {
        if(mails == null)
            throw new IllegalArgumentException("Invalid parameter mails!");
        this.mails = mails;
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
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        User other = (User) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
    
    @Override
    public int compareTo(User u)
    {
        if(id == u.id)            
            return 0;
        else if(id < u.id)
            return -1;
        else
            return 1;
    }
}
