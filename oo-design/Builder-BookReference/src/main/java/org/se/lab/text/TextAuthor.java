package org.se.lab.text;


public class TextAuthor // Part
    implements TextElement
{
    private String author;
    
    public TextAuthor(String author)
    {
        this.author = author;
    }
        
    public String toText()
    {
        return ", " + author;
    }    
}
