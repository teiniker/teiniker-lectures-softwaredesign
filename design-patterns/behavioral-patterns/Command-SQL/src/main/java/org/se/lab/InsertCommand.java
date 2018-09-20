package org.se.lab;

public class InsertCommand 
	implements SQLCommand
{
    /*
     * Constructor
     */
    public InsertCommand(User user)
    {
        setUser(user);
    }
    
    
    /*
     * Property: user:User
     */
    private User user;
    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
    	// TODO: validate user properties (against SQL injection)
    	this.user = user;
    }


    /*
     * Execute task
     */

    @Override
    public void execute()
    {
    	final String SQL = "INSERT INTO user VALUES (" + 
    			getUser().getId() + "," +
    			getUser().getUsername() + "," +
    			getUser().getPassword() + ")";
        System.out.println(SQL);
    }
}
