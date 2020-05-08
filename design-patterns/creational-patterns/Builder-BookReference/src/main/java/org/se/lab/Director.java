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
        builder.title("Design Patterns")
                .author("Erich Gamma")
                .author("Richard Helm")
                .author("Ralph Johnson")
                .author("John Vlissides");
    }
}
