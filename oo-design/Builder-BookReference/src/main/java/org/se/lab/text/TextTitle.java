package org.se.lab.text;


public class TextTitle // Part
    implements TextElement
{
    protected String title;
    
    public TextTitle(String title)
    {
        this.title = title;
    }
    
    public String toText()
    {
        return "\"" + title + "\"";
    }    
}
