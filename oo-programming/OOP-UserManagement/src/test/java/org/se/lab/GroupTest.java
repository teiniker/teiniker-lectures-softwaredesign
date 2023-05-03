package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.Group;
import org.se.lab.User;

public class GroupTest
{
    private Group g;

    @Before
    public void setup()
    {
        g = new Group(1, "students");
        
        User u1 = new User(3, "homer", "***");
        g.addUser(u1);
//        u1.setGroup(g);
        
        User u2 = new User(5, "marge", "***");
        g.addUser(u2);
//        u2.setGroup(g);
    }
    
    
    @Test
    public void testUsers()
    {
        Assert.assertEquals(2, g.getUsers().size());
        
        Assert.assertEquals("homer",g.getUsers().get(0).getUsername());
        Assert.assertEquals("marge",g.getUsers().get(1).getUsername());
    }
    
    
    @Test
    public void testUserToGroupToUser()
    {
        User u1 = g.getUsers().get(0);
        Assert.assertEquals("homer", u1.getUsername());
        
        Assert.assertEquals("students", u1.getGroup().getName());
    }
}
