package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class SerializationFactoryTest
{

    @Test
    public void testXmlSerializer()
    {
        SerializerFactory.setFormat(Format.XML);
        SerializerFactory factory = SerializerFactory.newFactory();        
        ArticleSerializer serializer = factory.createArticleSerializer();
         
        Article article = new Article(7, "Effective Java", 3336); 
        
        String expected = "<article id=\"7\" price=\"3336\">Effective Java</article>";
        String actual = serializer.serialize(article);
        Assert.assertEquals(expected, actual); 
    }

    
    @Test
    public void testJsonSerializer()
    {
        SerializerFactory.setFormat(Format.JSON);
        SerializerFactory factory = SerializerFactory.newFactory();        
        ArticleSerializer serializer = factory.createArticleSerializer();
         
        Article article = new Article(7, "Effective Java", 3336); 
        
        String expected = "{\"id\":\"7\",\"price\":\"3336\",\"description\":\"Effective Java\"}";
        String actual = serializer.serialize(article);
        Assert.assertEquals(expected, actual); 
    }

}
