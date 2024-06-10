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

        List<Double> result = numbers.stream()
                .filter(number -> number >= minValue && number <= maxValue)
                .toList();

        List<Double> expected = List.of(2.7, 3.2, 4.9);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testMinMaxLimit()
    {
        List<Double> numbers = List.of(1.5, 2.7, 3.2, 4.9, 5.1);
        double minValue = 2.0;
        double maxValue = 5.0;

        // The Math.max(number, minValue) ensures that the number is not
        // smaller than the minimum value, and Math.min(result, maxValue)
        // ensures that the resulting number is not greater than the
        // maximum value.

        List<Double> result = numbers.stream()
                .map(number -> Math.min(Math.max(number, minValue), maxValue))
                .toList();

        List<Double> expected = List.of(2.0, 2.7, 3.2, 4.9, 5.0);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testLowest3()
    {
        List<Double> numbers = List.of(1.5, 2.7, 3.2, 4.9, 5.1);

        List<Double> result = numbers.stream()
                .sorted()
                .limit(3)
                .toList();

        List<Double> expected = List.of(1.5, 2.7, 3.2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testTop3()
    {
        List<Double> numbers = List.of(1.5, 2.7, 3.2, 4.9, 5.1);

        // The lambda expression (a, b) -> Double.compare(b, a) is used
        // as the comparator to sort the numbers in reverse order.

        List<Double> result = numbers.stream()
                .sorted((a, b) -> Double.compare(b, a))
                .limit(3)
                .toList();

        List<Double> expected = List.of(5.1, 4.9, 3.2);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testAbsolutValue()
    {
        List<Double> numbers = List.of(-1.5, 2.7, -3.2, 4.9, -5.1);

        List<Double> result = numbers.stream()
                .map(Math::abs)
                .toList();

        List<Double> expected = List.of(1.5, 2.7, 3.2, 4.9, 5.1);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void testCountNegativeValues()
    {
        List<Double> numbers = List.of(-1.5, 2.7, -3.2, 4.9, -5.1);

        long result = numbers.stream()
                .filter(number -> number < 0)
                .count();

        Assert.assertEquals(3, result);
    }
}
