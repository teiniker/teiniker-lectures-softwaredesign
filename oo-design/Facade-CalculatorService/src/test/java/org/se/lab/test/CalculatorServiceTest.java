package org.se.lab.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.CalculatorService;


public class CalculatorServiceTest
{
    private final double DELTA = 0.0000001;
    private CalculatorService analysis;
    
    @Before
    public void setup()
    {
        analysis = new CalculatorService();
    }
    
    
    @Test
    public void testCalculateMeanValue()
    {
        List<Double> data = Arrays.asList(3.3, 1.1, 0.0, 2.2);
        
        double mean = analysis.calculateMeanValue(data);
        Assert.assertEquals(1.65, mean, DELTA);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testNullData()
    {
        analysis.calculateMeanValue(null);
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void testEmptyData()
    {
        analysis.calculateMeanValue(new ArrayList<Double>());
    }
}
