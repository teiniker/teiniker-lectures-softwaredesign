package org.se.lab;

public class Director
{
    private Builder builder;
    
    public Director(Builder builder)
    {
        this.builder = builder;
    }
    
    
    // TODO: pass a BookReference object
    public void construct()
    {
        builder.addTitle("Design Patterns");
        builder.addAuthor("Erich Gamma");
        builder.addAuthor("Richard Helm");
        builder.addAuthor("Ralph Johnson");
        builder.addAuthor("John Vlissides");
    }
}
