package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class User
    extends Entity

{
    /*
     * Constrcutor
     */
    public User(long id, String username, String password)
    {
        super(id);
        setUsername(username);
        setPassword(password);
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
        return getId() + "," + getUsername();
    }

}
