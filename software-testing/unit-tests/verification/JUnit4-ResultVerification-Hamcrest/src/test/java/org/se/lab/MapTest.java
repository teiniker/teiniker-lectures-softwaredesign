package org.se.lab;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MapTest
{
    private Map<String, Integer> map = new HashMap<>();

    @Before
    public void setup()
    {
        map.put("homer", 2);
        map.put("marge", 3);
        map.put("bart", 5);
        map.put("lisa", 7);
        map.put("maggie", 11);
    }


    @Test
    public void testHasKey()
    {
        assertThat(map, hasKey("lisa"));
    }

    @Test
    public void testHasValue()
    {
        assertThat(map, hasValue(5));
    }

    @Test
    public void testHasEntry()
    {
        assertThat(map, hasEntry("lisa", 7));
    }
}
