package org.se.lab.xml;


public class XmlTitle // Part
    implements XmlElement
{
    protected String title;
    
    public XmlTitle(String title)
    {
        this.title = title;
    }
    
    public String toXml()
    {
//        return "<title>" + title + "</title>";
    	StringBuilder builder = new StringBuilder();
    	
    	builder.append("<title>");
    	builder.append(title);
    	builder.append("</title>");
    	
    	return builder.toString();
    }    
}
