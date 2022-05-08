package org.se.lab;

public class Connection
{
    public Connection()
    {
        System.out.println("Connection.Connection() - constructor");
        setState(ConnectionClosed.INSTANCE);
    }
    
    
    /* 
     * Handle state
     */
    private ConnectionState state;
    protected void setState(ConnectionState state)
    {
        System.out.println("Connection.setState()");
        if(state == null)
            throw new IllegalArgumentException("State parameter is null!");        
        this.state = state;
    }
    
    
    /* 
     * Trigger methods
     */
    
    public void open()
    {
        System.out.println("Connection.open()");
        state.handleOpen(this);
    }
    
    public int send(String data)
    {
        System.out.println("Connection.send()");
        return state.handleSend(this, data);
    }
    
    public void close()
    {
        System.out.println("Connection.close()");
        state.handleClose(this);
    }
}
