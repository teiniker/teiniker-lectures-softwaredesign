package org.se.lab.xml;


public class XmlAuthor // Part
    implements XmlElement
{
    private String author;
    
    public XmlAuthor(String author)
    {
        this.author = author;
    }
        
    public String toXml()
    {
        return "<author>" + author + "</author>";
    }    
}
