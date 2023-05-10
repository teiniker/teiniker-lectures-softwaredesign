package org.se.lab;

import java.util.Date;

public class AnotherLogger
        extends Logger
{
    protected AnotherLogger()
    {
        super();
    }

    /*
     * Utility Methods
     */
    protected void print(String s)
    {
        System.out.println(new Date() + " [" + Thread.currentThread().getId() + "] " + s);
    }

}
