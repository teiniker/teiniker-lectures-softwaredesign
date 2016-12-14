package org.se.lab;

public class ToLowerOperation
    implements Operation
{
    @Override
    public String execute(String s)
    {
        return s.toLowerCase();
    }

}
