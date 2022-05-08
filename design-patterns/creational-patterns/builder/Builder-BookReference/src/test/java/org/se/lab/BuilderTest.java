package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.se.lab.text.TextBookReference;
import org.se.lab.text.TextBuilder;
import org.se.lab.xml.XmlBookReference;
import org.se.lab.xml.XmlBuilder;


public class BuilderTest
{
    @Test
    public void testTextBuilder()
    {
        TextBuilder builder = new TextBuilder();        
        Director director = new Director(builder);        
        director.construct();

        TextBookReference result = builder.getResult();
        System.out.println(result.toText());
        
        final String expected = "\"Design Patterns\", Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides";
        assertEquals(expected, result.toText());
    }

    @Test
    public void testXmlBuilder()
    {
        XmlBuilder builder = new XmlBuilder();
        Director director = new Director(builder);
        director.construct();

        XmlBookReference result = builder.getResult();
        System.out.println(result.toXml());
        
        final String expected = """
                <book>
                    <title>Design Patterns</title>
                    <author>Erich Gamma</author>
                    <author>Richard Helm</author>
                    <author>Ralph Johnson</author>
                    <author>John Vlissides</author>
                </book>""";
        assertEquals(expected, result.toXml());
    }
}
