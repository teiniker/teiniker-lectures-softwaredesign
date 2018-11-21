package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class CompositeTest
{
    @Test
    public void testItem()
    {
        XmlNode mo = new XmlText("Reminder");
        Assert.assertEquals("Reminder", mo.toXML());
    }
    
    
    @Test(expected=UnsupportedOperationException.class)
    public void testLeafAdd()
    {
        XmlNode t1 = new XmlText("Jani");
        XmlNode t2 = new XmlText("Tove");
        t1.addNestedElement(t2);
    }


    @Test
    public void testNestedElements()
    {
        XmlNode note = new XmlElement("note");

        XmlNode to = new XmlElement("to");
        note.addNestedElement(to);
        to.addNestedElement(new XmlText("Tove"));

        XmlNode from = new XmlElement("from");
        note.addNestedElement(from);
        from.addNestedElement(new XmlText("Jani"));

        XmlNode heading = new XmlElement("heading");
        note.addNestedElement(heading);
        heading.addNestedElement(new XmlText("Reminder"));

        XmlNode body = new XmlElement("body");
        note.addNestedElement(body);
        body.addNestedElement(new XmlText("Don't forget me this weekend!"));

        System.out.println(note.toXML());

        String expected =
                "<note>" +
                    "<to>Tove</to>" +
                    "<from>Jani</from>"+
                    "<heading>Reminder</heading>"+
                    "<body>Don't forget me this weekend!</body>" +
                "</note>";
        Assert.assertEquals(expected, note.toXML());
    }
}
