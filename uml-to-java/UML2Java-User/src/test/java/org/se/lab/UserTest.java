package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class UserTest
{
    private User bart;
    
    @Before
    public void setup()
    {
        bart = new User(3,"bart", "****");
    }

    @Test
    public void testUser()
    {        
        Assert.assertEquals(3, bart.getId());
        Assert.assertEquals("bart", bart.getUsername());
        Assert.assertEquals("****", bart.getPassword());
    }
    
    @Test
    public void testUserToString()
    {        
        String s = bart.toString();
        
        Assert.assertEquals("3,bart,****", s);
    }
}
