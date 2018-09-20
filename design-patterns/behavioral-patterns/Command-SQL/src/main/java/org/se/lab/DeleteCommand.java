package org.se.lab;

public class DeleteCommand
    implements SQLCommand
{
    /*
     * Constructor
     */
    public DeleteCommand(int id)
    {
        setId(id);
    }
    
    
    /*
     * Property: id:int
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
     * Execute task
     */

    @Override
    public void execute()
    {
    	final String SQL = "DELETE FROM user WHERE ID = " + getId();
        System.out.println(SQL);
    }
}
