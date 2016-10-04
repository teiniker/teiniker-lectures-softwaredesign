package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.se.lab.Director;
import org.se.lab.text.TextBuilder;
import org.se.lab.xml.XmlBuilder;


public class BuilderTest
{
    @Test
    public void testTextBuilder()
    {
        TextBuilder builder = new TextBuilder();        
        Director director = new Director(builder);        
     // TODO: pass a BookReference object
        director.construct();
        
        String result = builder.getResult();
        System.out.println(result);
        
        final String expected = "\"Design Patterns\", Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides";
        assertEquals(expected, result);
    }

    @Test
    public void testXmlBuilder()
    {
        XmlBuilder builder = new XmlBuilder();
        Director director = new Director(builder);
     // TODO: pass a BookReference object
        director.construct();

        String result = builder.getResult();        
        System.out.println(result);
        
        final String expected = "<book>\n" +
                                "    <title>Design Patterns</title>\n" +
                                "    <author>Erich Gamma</author>\n" +
                                "    <author>Richard Helm</author>\n" +
                                "    <author>Ralph Johnson</author>\n" + 
                                "    <author>John Vlissides</author>\n" + 
                                "</book>";        
        assertEquals(expected, result);
    }
}
