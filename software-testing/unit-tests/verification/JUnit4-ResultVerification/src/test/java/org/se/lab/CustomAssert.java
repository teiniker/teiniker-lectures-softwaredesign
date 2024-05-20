package org.se.lab;

import org.junit.Assert;

public class CustomAssert
{
    private CustomAssert() {}

    public static void assertEquals(User u1, User u2)
    {
        Assert.assertNotNull(u1);
        Assert.assertNotNull(u2);
        Assert.assertEquals(u1.getId(), u2.getId());
        Assert.assertEquals(u1.getUsername(), u2.getUsername());
        Assert.assertEquals(u1.getPassword(), u2.getPassword());
    }

}
