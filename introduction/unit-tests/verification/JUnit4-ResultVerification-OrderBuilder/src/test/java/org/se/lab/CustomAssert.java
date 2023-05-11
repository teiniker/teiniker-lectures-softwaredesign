package org.se.lab;

import org.junit.Assert;

public class CustomAssert
{

    public static void assertEquals(Order expected, Order actual)
    {
        Assert.assertNotNull(expected);
        Assert.assertNotNull(actual);
        
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getName(), actual.getName());
        
        Assert.assertEquals(expected.getOrderLines().size(), actual.getOrderLines().size());
        
        for(int i=0; i<expected.getOrderLines().size(); i++)
        {
            assertEquals(expected.getOrderLines().get(i), actual.getOrderLines().get(i));
        }
    }

    public static void assertEquals(OrderLine expected, OrderLine actual)
    {
        Assert.assertNotNull(expected);
        Assert.assertNotNull(actual);
        
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getQuantity(), actual.getQuantity());
        assertEquals(expected.getProduct(), actual.getProduct());
    }

    public static void assertEquals(Product expected, Product actual)
    {
        Assert.assertNotNull(expected);
        Assert.assertNotNull(actual);
        
        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getDescription(), actual.getDescription());
        Assert.assertEquals(expected.getPrice(), actual.getPrice());
    }

}
