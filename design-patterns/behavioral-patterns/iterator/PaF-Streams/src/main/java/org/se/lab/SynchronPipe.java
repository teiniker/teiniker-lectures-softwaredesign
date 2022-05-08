package org.se.lab;

import java.util.List;

public class SynchronPipe
    implements Pipe
{
    private Filter filter;

    public SynchronPipe(Filter filter)
    {
        this.filter = filter;
    }

    @Override
    public void write(List<String> list)
    {
        filter.process(list);
    }
}
