package org.se.lab;

public abstract class SerializerFactory
{
    private static Format format; 
    public static void setFormat(Format f)
    {
        format = f;
    }
    public static SerializerFactory newFactory()
    {
        switch(format)
        {
            case XML:
                return new XmlSerializerFactory();
                
            case JSON:
                return new JsonSerializerFactory();
                
            default: 
                throw new IllegalArgumentException("Unknown format!");
        }
    }
    
    /*
     * Factory Methods
     */
    
    public abstract ArticleSerializer createArticleSerializer();
    
    // Usually, there are some more createXXXSerializer() methods
}
