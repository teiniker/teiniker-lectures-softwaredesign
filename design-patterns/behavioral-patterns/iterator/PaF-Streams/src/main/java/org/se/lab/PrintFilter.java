package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class PrintFilter
    implements Filter
{
    @Override
    public void process(List<String> list)
    {
        for(String s : list)
        {
            System.out.println(s);
        }
    }
}
