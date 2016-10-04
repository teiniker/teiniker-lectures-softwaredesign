package org.se.lab.xml;

import org.se.lab.Builder;

public class XmlBuilder
    implements Builder
{
    private XmlBookReference document;
    
    public XmlBuilder()
    {
        reset();
    }
    
    public void reset()
    {
        document = new XmlBookReference();
    }
    
    public void addAuthor(String line)
    {
        document.addElement(new XmlAuthor(line));
    }

    public void addTitle(String title)
    {
        document.addElement(new XmlTitle(title));
    }

    
    public String getResult()
    {
        return document.toXml();
    }
}
