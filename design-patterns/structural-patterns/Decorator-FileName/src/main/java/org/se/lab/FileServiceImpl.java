package org.se.lab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

class FileServiceImpl // package private
    implements FileService
{
    private final Logger LOG = Logger.getLogger(FileServiceImpl.class);
    
    /*
     * Interface operations
     */

    public List<String> asList(String filename)
    {
        LOG.debug("asList(" + filename + ")");
        
        if(filename == null)
            throw new IllegalArgumentException("Invalid filename!");
        
        try
        {
            List<String> lines = new ArrayList<>();
            File file = new File(filename);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String s;
            while ((s = in.readLine()) != null)
            {
                lines.add(s);
            }
            in.close();
            return lines;
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Text file not loaded", e);
        }
    }
    
    public String asString(String filename)
    {
        LOG.debug("asString(" + filename + ")");
        
        List<String> list = asList(filename);
        
        StringBuilder builder = new StringBuilder();
        for(String s : list)
        {
            builder.append(s).append('\n');
        }
        
        return builder.toString();
    }
}