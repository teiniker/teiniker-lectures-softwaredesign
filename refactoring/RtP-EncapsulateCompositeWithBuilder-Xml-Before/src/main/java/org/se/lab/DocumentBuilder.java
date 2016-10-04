package org.se.lab;

public interface DocumentBuilder
{
    void beginElement(String name);

    void endElement();

    void addText(String text);

    void addAttribute(String name, String value);
}