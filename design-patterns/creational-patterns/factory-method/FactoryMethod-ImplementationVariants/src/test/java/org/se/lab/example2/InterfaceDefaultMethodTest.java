package org.se.lab.example2;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.Person;
import org.se.lab.example2.PersonFactory;
import org.se.lab.example2.PersonFactoryImpl;

public class InterfaceDefaultMethodTest
{
    @Test
    public void testCreationMethod()
    {
        PersonFactory factory = new PersonFactoryImpl();
        Person p = factory.createPerson(7, "Homer", "Simpson", "homer.simpson@springfield.org");

        Assert.assertEquals("7,Homer,Simpson,homer.simpson@springfield.org", p.toString());
    }
}
