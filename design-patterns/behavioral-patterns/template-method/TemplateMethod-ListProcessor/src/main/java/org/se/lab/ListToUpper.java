package org.se.lab;

public class ListToUpper
    extends ListProcessor
{
    /* 
     * Constructor 
     */
    public ListToUpper()
    {
        System.out.println("ListToUpper.ListToUpper() - constructor");
    }
    
    
    /* 
     * Primitive Operation 
     */
    protected String modifyElement(String element)
    {
        System.out.println("ListToUpper.modifyElement()");
        return element.toUpperCase();        
    }
}
