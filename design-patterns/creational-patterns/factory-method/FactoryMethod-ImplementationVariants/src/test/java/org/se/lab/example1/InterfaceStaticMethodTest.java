package org.se.lab.example2;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.Person;

public class InterfaceStaticMethodTest
{
    @Test
    public void testCreationMethod()
    {
        Person p = PersonFactory.createPerson(7, "Homer", "Simpson", "homer.simpson@springfield.org");

        Assert.assertEquals("7,Homer,Simpson,homer.simpson@springfield.org", p.toString());
    }
}
