package org.se.lab;

import java.util.List;

abstract class FileServiceDecorator // package private
    implements FileService
{
    /*
     * Reference: ---[1]-> FileService
     */
    private final FileService service;
    
    public FileServiceDecorator(FileService service)
    {
        if(service == null)
            throw new IllegalArgumentException("Invalid FileService reference!");
        this.service = service;
    }

    
    /*
     * Interface Operations
     */
    
    public List<String> asList(String filename)
    {
        return service.asList(filename);
    }
    
    public String asString(String filename)
    {
        return service.asString(filename);
    }
}
