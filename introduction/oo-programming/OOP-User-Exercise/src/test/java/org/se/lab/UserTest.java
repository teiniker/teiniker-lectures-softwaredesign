package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class UserTest
{
    @Test
    public void testConstructor()
    {
        User user = new User(3, "homer", "Hjg65hfFGDGF#75");

        Assert.assertEquals(3, user.getId());
        Assert.assertEquals("homer", user.getUsername());
        Assert.assertEquals("Hjg65hfFGDGF#75", user.getPassword());
    }

    @Test
    public void testAssociation()
    {
        // setup
        EMail m1 = new EMail(7, "egon.teiniker@fhj.at");
        EMail m2 = new EMail(11, "egon.teiniker@gmx.at");
        User user = new User(3, "homer", "Hjg65hfFGDGF#75");
        user.addMail(m1);
        user.addMail(m2);

        // exercise
        Assert.assertEquals(7, user.getMails().get(0).getId());
        Assert.assertEquals(11, user.getMails().get(1).getId());
        System.out.println(user);
    }

    @Test
    public void testBidirectionalAssociation()
    {
        // setup
        EMail m1 = new EMail(7, "egon.teiniker@fhj.at");
        EMail m2 = new EMail(11, "egon.teiniker@gmx.at");
        User user = new User(3, "homer", "Hjg65hfFGDGF#75");
        user.addMail(m1);
        m1.setUser(user);
        user.addMail(m2);
        m2.setUser(user);

        // exercise + verify
        EMail mail1 = user.getMails().get(0);
        Assert.assertEquals(7, mail1.getId());
        Assert.assertEquals(3, mail1.getUser().getId());

        EMail mail2 = user.getMails().get(1);
        Assert.assertEquals(11, mail2.getId());
        Assert.assertEquals(3, mail2.getUser().getId());
    }


    @Test
    public void testToString()
    {
        // setup
        EMail m1 = new EMail(7, "egon.teiniker@fhj.at");
        EMail m2 = new EMail(11, "egon.teiniker@gmx.at");
        User user = new User(3, "homer", "Hjg65hfFGDGF#75");
        user.addMail(m1);
        m1.setUser(user);
        user.addMail(m2);
        m2.setUser(user);

        // exercise
        String s = user.toString();

        // verify
        String expected = "User{id=3, username='homer'EMail{id=7, address='egon.teiniker@fhj.at'} EMail{id=11, address='egon.teiniker@gmx.at'} }";
        Assert.assertEquals(expected, s);
    }
}
