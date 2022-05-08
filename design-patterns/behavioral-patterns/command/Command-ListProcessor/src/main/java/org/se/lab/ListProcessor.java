package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ListProcessor
{
    public static List<String> process(List<String> list, Command cmd)
    {
        List<String> result = new ArrayList<>();
        
        for(String s : list)
        {
        	String r = cmd.process(s); 
            result.add(r);
        }
        return result;
    }
}
