package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DoubleListTest
{
    @Test
    public void testMinMaxFilter()
    {
        List<Double> numbers = List.of(1.5, 2.7, 3.2, 4.9, 5.1);
        double minValue = 2.0;
        double maxValue = 5.0;

        // TODO

        List<Double> expected = List.of(2.7, 3.2, 4.9);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMinMaxLimit()
    {
        List<Double> numbers = List.of(1.5, 2.7, 3.2, 4.9, 5.1);
        double minValue = 2.0;
        double maxValue = 5.0;

        // TODO

        List<Double> expected = List.of(2.0, 2.7, 3.2, 4.9, 5.0);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testLowest3()
    {
        List<Double> numbers = List.of(1.5, 2.7, 3.2, 4.9, 5.1);

        // TODO

        List<Double> expected = List.of(1.5, 2.7, 3.2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testTop3()
    {
        List<Double> numbers = List.of(1.5, 2.7, 3.2, 4.9, 5.1);

        // TODO

        List<Double> expected = List.of(5.1, 4.9, 3.2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testAbsolutValue()
    {
        List<Double> numbers = List.of(-1.5, 2.7, -3.2, 4.9, -5.1);

        // TODO

        List<Double> expected = List.of(1.5, 2.7, 3.2, 4.9, 5.1);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCountNegativeValues()
    {
        List<Double> numbers = List.of(-1.5, 2.7, -3.2, 4.9, -5.1);

        // TOOD

        Assert.assertEquals(3, result);
    }
}
