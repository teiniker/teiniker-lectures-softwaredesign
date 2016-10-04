package org.se.lab;

public interface DocumentBuilder
{
    DocumentBuilder beginElement(String name);

    DocumentBuilder endElement();

    DocumentBuilder addText(String text);

    DocumentBuilder addAttribute(String name, String value);
}