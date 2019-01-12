package org.se.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ToUpperFilter
    implements Filter
{
    private Pipe pipe;

    public ToUpperFilter(Pipe pipe)
    {
        this.pipe = pipe;
    }

    @Override
    public void process(List<String> list)
    {
        List<String> result = new ArrayList<>();
        for(String s : list)
        {
            result.add(s.toUpperCase());
        }
        pipe.write(result);
    }
}
