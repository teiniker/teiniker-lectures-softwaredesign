package org.se.lab;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ArrayTest
{
    private String[] array = new String[] {"homer", "marge", "bart", "lisa", "maggie"};

    @Test
    public void testSize()
    {
        assertThat(array, arrayWithSize(5));
    }

    @Test
    public void testContains()
    {
        assertThat(array, arrayContaining("homer", "marge", "bart", "lisa", "maggie"));
    }

    @Test
    public void testContainsInAnyOrder()
    {
        assertThat(array, arrayContainingInAnyOrder("marge", "homer", "maggie", "bart", "lisa"));
    }

    @Test
    public void testHasItem()
    {
        assertThat(array, hasItemInArray("bart"));
    }

    @Test
    public void testIsIn()
    {
        assertThat("bart", isIn(array));
    }
}
