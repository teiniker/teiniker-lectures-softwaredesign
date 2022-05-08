package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSource
    implements Filter
{
    private Pipe pipe;

    public DataSource(List<String> data, Pipe pipe)
    {
        this.pipe = pipe;
        process(data);
    }

    @Override
    public void process(List<String> data)
    {
        pipe.write(data);
    }
}
