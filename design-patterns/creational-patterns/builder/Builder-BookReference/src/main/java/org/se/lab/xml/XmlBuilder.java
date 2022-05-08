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
    
    public XmlBuilder author(String line)
    {
        document.addElement(new XmlAuthor(line));
        return this;
    }

    public XmlBuilder title(String title)
    {
        document.addElement(new XmlTitle(title));
        return this;
    }

    
    public XmlBookReference getResult()
    {
        return document;
    }
}
