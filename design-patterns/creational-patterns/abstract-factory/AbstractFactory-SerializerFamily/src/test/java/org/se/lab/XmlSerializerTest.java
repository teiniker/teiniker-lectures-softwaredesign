package org.se.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class XmlSerializerTest
{
    private ArticleSerializer serializer = new ArticleXmlSerializer();

    @Test
    public void testSerializeArticle()
    {
        Article article = new Article(7, "Effective Java", 3336); 
        
        String expected = "<article id=\"7\" price=\"3336\">Effective Java</article>";
        String actual = serializer.serialize(article);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSerializeArticleList()
    {
        List<Article> list = Arrays.asList(
                new Article(7, "Effective Java", 3336),
                new Article(11, "Design Patterns. Elements of Reusable Object-Oriented Software", 4295),
                new Article(13, "Head First Design Patterns", 4095));
        
        String expected = 
                "<articles>" +
                    "<article id=\"7\" price=\"3336\">Effective Java</article>" +
                    "<article id=\"11\" price=\"4295\">Design Patterns. Elements of Reusable Object-Oriented Software</article>" +
                    "<article id=\"13\" price=\"4095\">Head First Design Patterns</article>" +
                "</articles>";
        String actual = serializer.serialize(list);
        Assert.assertEquals(expected, actual);
    }
    
    
}
