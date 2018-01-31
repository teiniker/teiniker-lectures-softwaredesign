package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.Item;
import org.se.lab.ItemList;
import org.se.lab.XMLElement;

public class CompositeTest
{

    @Test
    public void testItem()
    {
        XMLElement mo = new Item("Montag");
        Assert.assertEquals("<item>Montag</item>", mo.toXML());
    }
    
    
    @Test(expected=UnsupportedOperationException.class)
    public void testLeafAdd()
    {
        XMLElement mo = new Item("Montag");
        XMLElement di = new Item("Dienstag");
        mo.addItem(di);
    }
    
    
    @Test
    public void testItemList()
    {
        XMLElement dayList = new ItemList();  
        dayList.addItem(new Item("Montag"));        
        dayList.addItem(new Item("Dienstag"));
        dayList.addItem(new Item("Mittwoch"));
        
        XMLElement hourList = new ItemList();
        hourList.addItem(new Item("10:00 am"));
        hourList.addItem(new Item("11:00 am"));
        
        dayList.addItem(hourList);
        
        String expected = 
        "<itemlist>" + "\n" + 
        "    <item>Montag</item>" + "\n" + 
        "    <item>Dienstag</item>" + "\n" + 
        "    <item>Mittwoch</item>" + "\n" + 
        "    <itemlist>" + "\n" + 
        "        <item>10:00 am</item>" + "\n" +
        "        <item>11:00 am</item>" + "\n" +
        "    </itemlist>" + "\n" +
        "</itemlist>";        
        Assert.assertEquals(expected, dayList.toXML());
        System.out.println(dayList.toXML());
    }
}
