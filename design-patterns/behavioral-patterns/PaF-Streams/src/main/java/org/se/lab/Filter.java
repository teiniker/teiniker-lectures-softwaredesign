package org.se.lab;

import java.util.List;
import java.util.function.Function;

@FunctionalInterface
public interface Filter
{
    void process(List<String> list);
}
