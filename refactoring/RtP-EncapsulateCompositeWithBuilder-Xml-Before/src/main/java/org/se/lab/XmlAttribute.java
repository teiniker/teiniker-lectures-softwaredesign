package org.se.lab;

public class XmlAttribute
{
    /*
     * Constructor
     */
    public XmlAttribute(String name, String value)
    {
        setAttributeName(name);
        setValue(value);
    }
    
    
    /*
     * Property: attributeName:String
     */
    private String attributeName;
    public String getAttributeName()
    {
        return attributeName;
    }
    public void setAttributeName(String attributeName)
    {
        if(attributeName == null)
            throw new NullPointerException();
        this.attributeName = attributeName;
    }
    
    
    /*
     * Property: value
     */
    private String value;
    public String getValue()
    {
        return value;
    }
    public void setValue(String value)
    {
        if(value == null)
            throw new NullPointerException();
        this.value = value;
    }
}
