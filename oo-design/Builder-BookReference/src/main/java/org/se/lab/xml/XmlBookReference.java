package org.se.lab.xml;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class XmlBookReference // Product
    implements XmlElement
{
    private List<XmlElement> elements = new ArrayList<XmlElement>();
    
    public void addElement(XmlElement element)
    {
        elements.add(element);
    }
    
    public List<XmlElement> getElements()
    {
        return Collections.unmodifiableList(elements);
    }

    public String toXml()
    {
        StringBuilder out = new StringBuilder();
        out.append("<book>").append("\n");
        for(XmlElement element : getElements())
        {
            out.append("    ").append(element.toXml()).append("\n");
        }        
        out.append("</book>");
        return out.toString();
    }
}
