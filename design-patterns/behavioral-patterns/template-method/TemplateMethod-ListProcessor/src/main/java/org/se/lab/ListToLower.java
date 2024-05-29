package org.se.lab;

public class ListToLower
    extends ListProcessor
{
    /*
     * Constructor 
     */
    public ListToLower()
    {
        System.out.println("ListToLower.ListToLower() - constructor");
    }
    
    
    /* 
     * Primitive Operation 
     */
    @Override
    protected String modifyElement(String element)
    {
        System.out.println("ListToLower.modifyElement()");
        return element.toLowerCase();        
    }
    
    
    /*
     * Hook Operation
     */
    @Override
    protected void printElement(String element)
    {
        System.out.println("> " + element);
    }
}
