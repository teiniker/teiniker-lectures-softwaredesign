package org.se.lab.data;

public class TableException
    extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /*
     * Constructors
     */

    public TableException(String message)
    {
        super(message);
    }
    
    public TableException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
