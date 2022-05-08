package org.se.lab.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.FileService;
import org.se.lab.ServiceFactory;



public class FileNameDecoratorTest
{
    private FileService service;
    
    @Before
    public void setup()
    {
        service = ServiceFactory.INSTANCE.createFileService();
    }
    
    @Test
    public void testAsList()
    {
        List<String> list = service.asList("Sympathy.txt");
        
        Assert.assertEquals(5, list.size());
        Assert.assertEquals("Have some courtesy", list.get(1));
    }

    @Test
    public void testAsString()
    {
        String actual = service.asString("Sympathy.txt");
        
        String expected =
                """
                        So if you meet me
                        Have some courtesy
                        Have some sympathy, and some taste
                        Use all your well-learned politesse
                        Or I'll lay your soul to waste.
                        """;
        
        Assert.assertEquals(expected, actual);
    }
}
