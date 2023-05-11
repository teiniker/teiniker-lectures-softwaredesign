package org.se.lab;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StringTest
{
    @Test
    public void testIsEmptyString()
    {
        assertThat("", isEmptyString());
    }


    @Test
    public void testIsEmptyOrNullString()
    {
        assertThat(null, isEmptyOrNullString());
    }

    @Test
    public void testEqualToIgnoringWhiteSpace()
    {
        assertThat("homer", equalToIgnoringWhiteSpace( "   homer  "));
    }

    @Test
    public void testEqualToIgnoringCase()
    {
        assertThat("homer", equalToIgnoringCase( "HoMeR"));
    }

    @Test
    public void testContains()
    {
        assertThat("homer simpson", containsString("simpson"));
    }

    @Test
    public void testContainsInOrder()
    {
        assertThat("homer simpson", stringContainsInOrder(Arrays.asList("homer", "simpson")));
    }

    @Test
    public void testStartsWith()
    {
        assertThat("homer simpson", startsWith("hom"));
    }

    @Test
    public void testEndsWith()
    {
        assertThat("homer simpson", endsWith("son"));
    }

    @Test
    public void testNot()
    {
        assertThat("homer", not(equalTo("lisa")));
    }

    @Test
    public void testAnyOf()
    {
        assertThat("homer simpson", anyOf(startsWith("homer"), startsWith("lisa"))); // logical OR
    }

    @Test
    public void testAllOf()
    {
        assertThat("homer simpson", allOf(startsWith("homer"), endsWith("son"))); // logical AND
    }

}
