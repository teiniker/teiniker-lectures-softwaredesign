package org.se.lab.test;

import org.junit.Test;
import org.se.lab.Connection;


public class ConnectionStateTest
{
    @Test
    public void testConnection()
    {
        Connection connection = new Connection();
        connection.open();
        connection.send("some data");
        connection.close();
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testSendToClosedConnection()
    {
        Connection connection = new Connection();
        connection.send("some data"); // send to a closed connection !!
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testDoubleOpen()
    {
        Connection connection = new Connection();
        connection.open();
        connection.open(); // reopen an open connection !!
    }
    
    
    @Test(expected = IllegalStateException.class)
    public void testDoubleClose()
    {
        Connection connection = new Connection();
        connection.close(); // close a closed connection!!           
    }
}
