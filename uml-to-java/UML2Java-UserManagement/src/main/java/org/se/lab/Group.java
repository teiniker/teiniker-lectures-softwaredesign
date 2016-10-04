package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class Group
    extends Entity
{
    /*
     * Constructor
     */
    public Group(int id, String name)
    {
        setId(id);
        setName(name);
    }
    
    
    /*
     * Property: name:String
     */
    private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        if(name == null)
            throw new IllegalArgumentException();
        this.name = name;
    }
    
    
    /*
     * Association: ---[*]-> users:User
     */
    private List<User> users = new ArrayList<User>();
    public void addUser(User user)
    {
        if(user == null)
            throw new IllegalArgumentException();
        users.add(user);
        user.setGroup(this); // automatically set the user's group too
    }
    public List<User> getUsers()
    {
        return users;
    }
}
