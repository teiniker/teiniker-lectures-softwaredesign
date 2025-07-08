package org.se.lab;

@FunctionalInterface
public interface Command
{
    String process(String s);
}
