package org.se.lab.example0;

import org.junit.Assert;
import org.junit.Test;

public class InterfaceFinalFieldTest
{
    @Test
    public void testDefaultFactoryMethod()
    {
        Person p = PersonFactory.INSTANCE.createPerson(7, "Homer", "Simpson", "homer.simpson@springfield.org");

        Assert.assertEquals("7,Homer,Simpson,homer.simpson@springfield.org", p.toString());
    }

}
