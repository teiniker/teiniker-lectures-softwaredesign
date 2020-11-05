package org.se.lab;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest
{
    @Before
    public void setup()
    {
        System.out.println("setup()");
    }

    @After
    public void teardown()
    {
        System.out.println("teardown()");
    }

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

        for(EMail mail : user.getMails())
        {
            System.out.println(mail);
        }
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

        // exercise
        EMail mail1 = user.getMails().get(0);
        Assert.assertEquals(7, mail1.getId());
        Assert.assertEquals(3, mail1.getUser().getId());

        EMail mail2 = user.getMails().get(1);
        Assert.assertEquals(11, mail2.getId());
        Assert.assertEquals(3, mail2.getUser().getId());

        for(EMail mail : user.getMails())
        {
            System.out.println(mail + " -> " + mail.getUser());
        }
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
        System.out.println(s);
    }
}
