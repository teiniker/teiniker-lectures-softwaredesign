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
    
    public TextBuilder author(String line)
    {
        reference.addElement(new TextAuthor(line));
        return this;
    }

    public TextBuilder title(String title)
    {
        reference.addElement(new TextTitle(title));
        return this;
    }

    
    public TextBookReference getResult()
    {
        return reference;
    }
}
