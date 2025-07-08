package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ListProcessor
{
    public static List<String> process(List<String> list)
    {
        List<String> result = new ArrayList<>();
        
        for(String s : list)
        {
            result.add(s.toLowerCase());
        }
        return result;
    }
}
