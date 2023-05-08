package org.se.lab;

public class ServiceFactoryImpl
    implements ServiceFactory
{
    @Override
    public FileService createFileService()
    {
        return new FileNameDecorator(new FileServiceImpl(), "src/test/resources");
    }
}
