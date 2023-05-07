package org.se.lab;

public class User
    extends Entity
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
            throw new IllegalArgumentException();
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
            throw new IllegalArgumentException();   
        this.password = password;
    }
    
    
    /*
     * Association: ---[1]-> group:Group
     */
    private Group group;
    public Group getGroup()
    {
        return group;
    }
    public void setGroup(Group group)
    {
        if(group == null)
            throw new IllegalArgumentException();
        this.group = group;
    }
    
    
    @Override
    public String toString()
    {
        return getId() + "," + getUsername() + "," + getPassword();
    }
}
