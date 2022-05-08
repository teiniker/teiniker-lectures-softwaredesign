package org.se.lab;

class ConnectionEstablished
    implements ConnectionState
{
    public static final ConnectionState INSTANCE = new ConnectionEstablished();
    
    private ConnectionEstablished()
    {
        System.out.println("ConnectionEstablished.ConnectionEstablished() - constructor");
    }
    
    
    public void handleOpen(Connection c)
    {
        System.out.println("ConnectionEstablished.handleOpen()");
        throw new IllegalStateException("Connection is already open!");
    }
    
    public void handleClose(Connection c)
    {
        System.out.println("ConnectionEstablished.handleClose()");
        System.out.println(">>> connection closed!");
        c.setState(ConnectionClosed.INSTANCE);
    }
    
    public int handleSend(Connection c, String data)
    {
        System.out.println("ConnectionEstablished.handleSend()");
        System.out.println("handleSend> " + data);
        return data.length();
    }
}
