package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class User
    extends Entity
{
    /*
     * Constructor:
     */
    public User(long id, String username, String password)
    {
        setId(id);
        setUsername(username);
        setPassword(password);
    }


    /*
     * Property: username : String
     */
    private String username;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        if(username == null)
            throw new IllegalArgumentException("username is null!");

        this.username = username;
    }


    /*
     * Property: password : String
     */
    private String password;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        if(password == null)
            throw new IllegalArgumentException("password is null!");

        this.password = password;
    }


    /*
     * Association: User ---[1]-> EMail
     */
/*
    private EMail mail;
    public EMail getMail()
    {
        return mail;
    }
    public void setMail(EMail mail)
    {
        if(mail == null)
            throw new IllegalArgumentException("Invalid EMail object (null)!");
        this.mail = mail;
    }
*/
    /*
     * Association: User ---[*]-> EMail
     */

    private List<EMail> mails = new ArrayList<>();
    public List<EMail> getMails()
    {
        return mails;
    }
    public void setMail(EMail mail)
    {
        if(mail == null)
            throw new IllegalArgumentException("mail is null!");

        mails.add(mail);
    }


    /*
     * Object methods
     */

    @Override
    public String toString()
    {
        return "User{" +
                "id=" + getId() +
                ", username='" + username + '\'' +
                '}';
    }
}
