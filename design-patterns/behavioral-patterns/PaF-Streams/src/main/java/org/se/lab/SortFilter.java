package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortFilter
    implements Filter
{
    private Pipe pipe;

    public SortFilter(Pipe pipe)
    {
        this.pipe = pipe;
    }

    @Override
    public void process(List<String> list)
    {
        Collections.sort(list);
        pipe.write(new ArrayList<String>(list));
    }
}
