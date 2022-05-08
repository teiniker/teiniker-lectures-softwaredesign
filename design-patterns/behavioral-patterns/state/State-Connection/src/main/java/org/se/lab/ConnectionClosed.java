package org.se.lab;

class ConnectionClosed
    implements ConnectionState
{
    public static final ConnectionState INSTANCE = new ConnectionClosed();
    
    private ConnectionClosed()
    {
        System.out.println("ConnectionClosed.ConnectionClosed() - constructor");
    }
    
    
    public void handleOpen(Connection c)
    {
        System.out.println("ConnectionClosed.handleOpen()");
        System.out.println(">>> connection opened!");
        c.setState(ConnectionEstablished.INSTANCE);
    }
    
    public void handleClose(Connection c)
    {
        System.out.println("ConnectionClosed.handleClose()");
        throw new IllegalStateException("Connection is not open!");
    }
    
    public int handleSend(Connection c, String data)
    {
        System.out.println("ConnectionClosed.handleSend()");
        throw new IllegalStateException("Connection is not open!");
    }
}
