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
                "So if you meet me\n"+
                "Have some courtesy\n"+
                "Have some sympathy, and some taste\n"+
                "Use all your well-learned politesse\n"+
                "Or I'll lay your soul to waste.\n";
        
        Assert.assertEquals(expected, actual);
    }
}
