package org.se.lab;

import java.util.List;

public class ListProcessor
{
    public void process(List<String> list)
    {
        System.out.println("ListProcessor.process()");
        
        for(int i=0; i<list.size(); i++)
        {
        	String element = list.get(i).toUpperCase();
            printElement(element); 
            list.set(i, element);
        }
    }

    protected void printElement(String element)
    {
        System.out.println("> " + element);
    }
}
