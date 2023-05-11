package org.se.lab;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class NumberTest
{
    @Test
    public void testGreaterThan()
    {
        assertThat(7, greaterThan(5));
    }

    @Test
    public void testGreaterThanOrEqual()
    {
        assertThat(7, greaterThanOrEqualTo(7));
    }

    @Test
    public void testLessThan()
    {
        assertThat(5, lessThan(7));
    }

    @Test
    public void testLessThanOrEqualTo()
    {
        assertThat(5, lessThanOrEqualTo(5));
    }

    @Test
    public void testCloseTo()
    {
        assertThat(3.1415, closeTo(3.14, 0.01)); // [3.14-0.01, 3.14+0.01]
    }
}
