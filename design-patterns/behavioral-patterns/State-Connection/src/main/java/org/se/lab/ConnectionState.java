package org.se.lab;

interface ConnectionState
{
    void handleOpen(Connection c);
    int handleSend(Connection c, String data);
    void handleClose(Connection c);    
}
