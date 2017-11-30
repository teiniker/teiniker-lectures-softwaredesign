package org.se.lab.example1;

import org.junit.Assert;
import org.junit.Test;

public class PersonFactoryTest
{
    @Test
    public void testCreationMethod()
    {
        Person p = PersonFactory.createPerson(7, "Homer", "Simpson", "homer.simpson@springfield.org");

        Assert.assertEquals("7,Homer,Simpson,homer.simpson@springfield.org", p.toString());
    }


    @Test
    public void testDefaultFactoryMethod()
    {
        Person p = PersonFactory.INSTANCE.newPerson(7, "Homer", "Simpson", "homer.simpson@springfield.org");

        Assert.assertEquals("7,Homer,Simpson,homer.simpson@springfield.org", p.toString());
    }

}
