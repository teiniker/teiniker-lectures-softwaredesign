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
        this.password = password;
    }


    /*
     * Association: User ---[*]-> EMail
     */
    private List<EMail> mails = new ArrayList<>();
    public List<EMail> getMails()
    {
        return mails;
    }
    public void addMail(EMail mail)
    {
        mails.add(mail);
    }


    /*
     * Object methods
     */

    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        b.append("User{")
                .append("id=").append(getId())
                .append(", username='").append(username).append("'");
        for(EMail mail : getMails())
        {
            b.append(mail.toString()).append(' ');
        }
        b.append('}');
        return  b.toString();
    }
}
