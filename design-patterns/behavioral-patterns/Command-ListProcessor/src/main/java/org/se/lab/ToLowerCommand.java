package org.se.lab;

public class ToLowerCommand
    implements Command
{
    @Override
    public String process(String s)
    {
        return s.toLowerCase();
    }

}
