package org.se.lab;

import java.io.File;
import java.util.List;

class FileNameDecorator // package private
    extends FileServiceDecorator
{
    public FileNameDecorator(FileService service, String baseDir)
    {
        super(service);
        setBaseDir(baseDir);
    }
    
    /*
     * Property: baseDir
     */
    private String baseDir;
    public String getBaseDir()
    {
        return baseDir;
    }
    public void setBaseDir(String baseDir)
    {
        this.baseDir = baseDir;
    }


    @Override
    public List<String> asList(String filename)
    {
        return super.asList(getBaseDir() + File.separatorChar + filename);
    }
    
    @Override
    public String asString(String filename)
    {
        return super.asString(getBaseDir() + File.separatorChar + filename);
    }    
}
