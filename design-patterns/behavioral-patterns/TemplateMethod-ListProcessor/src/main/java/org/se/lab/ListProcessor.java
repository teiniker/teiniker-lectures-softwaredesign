package org.se.lab;

import java.util.List;

public abstract class ListProcessor
{
    /*
     * Template Method
     */
    
    public final void process(List<String> list)
    {
        System.out.println("ListProcessor.process()");
        
        for(int i=0; i<list.size(); i++)
        {
        	String element = modifyElement(list.get(i)); // call abstract primitive method
            printElement(element); // call hook method
            list.set(i, element);
        }
    }
    
    
    /*
     * Primitive Operation
     */
    
    protected abstract String modifyElement(String element);
    
 
    /*
     * Hook Operation
     */
    
    protected void printElement(String element)
    {
        // default behavior - do nothing
    }
}
