package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.example0.Person;
import org.se.lab.example0.PersonFactory;

public class InterfaceFinalFieldTest
{
    @Test
    public void testDefaultFactoryMethod()
    {
        Person p = PersonFactory.INSTANCE.createPerson(7, "Homer", "Simpson", "homer.simpson@springfield.org");

        Assert.assertEquals("7,Homer,Simpson,homer.simpson@springfield.org", p.toString());
    }

}
