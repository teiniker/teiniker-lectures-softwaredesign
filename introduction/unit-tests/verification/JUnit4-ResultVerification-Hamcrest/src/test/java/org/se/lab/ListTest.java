package org.se.lab;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ListTest
{
    private List<String> list = Arrays.asList("homer", "marge", "bart", "lisa", "maggie");

    @Test
    public void testEmptyList()
    {
        List<String> empty = Collections.emptyList();

        assertThat(empty, empty());
    }

    @Test
    public void testSize()
    {
        assertThat(list, hasSize(5));
    }

    @Test
    public void testContains()
    {
        assertThat(list, contains("homer", "marge", "bart", "lisa", "maggie"));
    }

    @Test
    public void testContainsInAnyOrder()
    {
        assertThat(list, containsInAnyOrder("marge", "homer", "maggie", "bart", "lisa"));
    }

    @Test
    public void testHasItem()
    {
        assertThat(list, hasItem("bart"));
    }

    @Test
    public void testIsIn()
    {
        assertThat("bart", isIn(list));
    }

}
