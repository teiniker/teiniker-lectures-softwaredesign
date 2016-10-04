package org.se.lab.text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TextBookReference // Product
    implements TextElement
{
    private List<TextElement> elements = new ArrayList<TextElement>();
    
    public void addElement(TextElement element)
    {
        elements.add(element);
    }
    
    public List<TextElement> getElements()
    {
        return Collections.unmodifiableList(elements);
    }

    public String toText()
    {
        StringBuilder out = new StringBuilder();
        for(TextElement element : getElements())
        {
            out.append(element.toText());
        }        
        return out.toString();
    }
}
