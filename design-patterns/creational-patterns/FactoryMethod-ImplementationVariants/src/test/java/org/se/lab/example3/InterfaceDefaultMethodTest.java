package org.se.lab.example3;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.Person;
import org.se.lab.example1.PersonFactory;
import org.se.lab.example1.PersonFactoryImpl;

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
