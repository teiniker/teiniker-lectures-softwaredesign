package org.se.lab;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.Article;
import org.se.lab.ArticleJsonSerializer;
import org.se.lab.ArticleSerializer;


public class JsonSerializerTest
{
    private ArticleSerializer serializer = new ArticleJsonSerializer();

    @Test
    public void testSerializeArticle()
    {
        Article article = new Article(7, "Effective Java", 3336); 
        
        String expected = "{\"id\":\"7\",\"price\":\"3336\",\"description\":\"Effective Java\"}";
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
                "[" +
                    "{\"id\":\"7\",\"price\":\"3336\",\"description\":\"Effective Java\"}," +
                    "{\"id\":\"11\",\"price\":\"4295\",\"description\":\"Design Patterns. Elements of Reusable Object-Oriented Software\"}," +
                    "{\"id\":\"13\",\"price\":\"4095\",\"description\":\"Head First Design Patterns\"}" +
                "]";
        String actual = serializer.serialize(list);
        Assert.assertEquals(expected, actual);
    }
}
