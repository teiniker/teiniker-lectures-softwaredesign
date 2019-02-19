package org.se.lab;

import java.util.List;

public interface FileService
{
    List<String> asList(String filename);
    
    String asString(String filename);
}
