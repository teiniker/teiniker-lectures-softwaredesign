package org.se.lab;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OptionalTest
{

    @Test
    public void testEmpty()
    {
        Optional<String> opt = Optional.empty();

        assertFalse(opt.isPresent());
    }

    @Test
    public void testOf()
    {
        String name = "Homer";
        Optional<String> opt = Optional.of(name);

        assertTrue(opt.isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void testOf_Null()
    {
        Optional<String> opt = Optional.of(null);
    }

    @Test
    public void testOfNullable()
    {
        Optional<String> opt = Optional.ofNullable(null);

        assertFalse(opt.isPresent());
    }

    @Test
    public void testIfPresent()
    {
        String name = "Homer";
        Optional<String> opt = Optional.of(name);

        opt.ifPresent(n -> System.out.println("name = " + n));
    }

    @Test
    public void testOrElse()
    {
        String name = null;
        String defaultName = Optional.ofNullable(name).orElse("Bart");

        assertEquals("Bart", defaultName);
    }

    @Test
    public void testOrElseGet()
    {
        String name = null;
        String defaultName = Optional.ofNullable(name).orElseGet(() ->"Bart");

        assertEquals("Bart", defaultName);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testOrElseThrow()
    {
        String name = null;
        // if name is null, throw an IllegalArgumentException
        String defaultName = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);
    }

    @Test
    public void testFilter()
    {
        String name = "Homer";
        Optional<String> opt = Optional.of(name).filter(n -> n.length() > 5);
        assertFalse(opt.isPresent());

        name = "Simpson";
        opt = Optional.of(name).filter(n -> n.length() > 5);
        assertTrue(opt.isPresent());
    }

}
