package org.se.lab.text;

import org.se.lab.Builder;

public class TextBuilder
    implements Builder
{
    private TextBookReference reference;
    
    public TextBuilder()
    {
        reset();
    }
    
    public void reset()
    {
        reference = new TextBookReference();
    }
    
    public void addAuthor(String line)
    {
        reference.addElement(new TextAuthor(line));
    }

    public void addTitle(String title)
    {
        reference.addElement(new TextTitle(title));
    }

    
    public String getResult()
    {
        return reference.toText();
    }
}
