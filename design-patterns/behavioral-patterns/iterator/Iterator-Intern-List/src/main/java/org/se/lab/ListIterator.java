package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ListIterator
{
    public static List<String> apply(List<String> list, Operation operation)
    {
        List<String> result = new ArrayList<>();
        
        for(String s : list)
        {
        	String r = operation.execute(s); 
            result.add(r);
        }
        return result;
    }
}
