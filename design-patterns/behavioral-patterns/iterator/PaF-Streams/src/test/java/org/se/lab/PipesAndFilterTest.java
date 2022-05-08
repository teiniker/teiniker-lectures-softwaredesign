package org.se.lab;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PipesAndFilterTest
{
    private List<String> data;
    private Filter stream;

    @Before
    public void setup()
    {
    }

    @Test
    public void testPipesAndFilters()
    {
        data = Arrays.asList("eins","zwei","drei","vier","fünf","sechs","sieben","acht","neun");
        stream =  new DataSource(data, new SynchronPipe(new ToUpperFilter(new SynchronPipe(new SortFilter(new SynchronPipe(new PrintFilter()))))));

    }

}
