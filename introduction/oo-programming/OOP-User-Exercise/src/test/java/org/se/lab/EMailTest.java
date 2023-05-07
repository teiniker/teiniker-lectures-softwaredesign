package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class EMailTest
{
    @Test
    public void testConstructor()
    {
        EMail mail = new EMail(7, "egon.teiniker@fhj.at");

        Assert.assertEquals(7, mail.getId());
        Assert.assertEquals("egon.teiniker@fhj.at", mail.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_InvalidId()
    {
        new EMail(-7, "egon.teiniker@fhj.at");
    }


    @Test
    public void testEqualsAndHashCode()
    {
        EMail m1 = new EMail(7, "egon.teiniker@fhj.at");
        EMail m2 = new EMail(7, "egon.teiniker@fhj.at");

        Assert.assertFalse(m1 == m2); // don't compare objects with ==

        Assert.assertTrue(m1.equals(m2));
        Assert.assertTrue(m1.hashCode() == m2.hashCode());
    }

    @Test
    public void testToString()
    {
        EMail mail = new EMail(7, "egon.teiniker@fhj.at");

        Assert.assertEquals("EMail{id=7, address='egon.teiniker@fhj.at'}", mail.toString());
    }
}
