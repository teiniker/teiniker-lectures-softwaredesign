package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XmlElement
{
    /*
     * Constructor
     */
    public XmlElement(String name)
    {
        setElementName(name);
    }
    
    
    /*
     * Property: elementName:String
     */
    private String elementName;
    public String getElementName()
    {
        return elementName;
    }
    public void setElementName(String elementName)
    {
        if(elementName == null)
            throw new NullPointerException();
        this.elementName = elementName;
    }
    
    
    /*
     * Property: text:String [0..1]
     */
    private String text;
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }
    
    
    /*
     * Association: ---[*]-> attributes
     */
    private List<XmlAttribute> attributes = new ArrayList<XmlAttribute>();
    public void addAttribute(XmlAttribute attribute)
    {
        if(attribute == null)
            throw new NullPointerException();
        attributes.add(attribute); 
    }
    public List<XmlAttribute> getAttributes()
    {
        return Collections.unmodifiableList(attributes);
    }
    
    
    /*
     * Association: ---[*]-> elements:XmlNode
     */
    private List<XmlElement> elements = new ArrayList<XmlElement>();
    public void addElement(XmlElement element)
    {
        if(element == null)
            throw new NullPointerException();
        elements.add(element);
    }
    public List<XmlElement> getElements()
    {
        return Collections.unmodifiableList(elements);
    }
}
