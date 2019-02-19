package org.se.lab;

class ServiceFactoryImpl // package private
    implements ServiceFactory
{

    @Override
    public FileService createFileService()
    {
        return new FileNameDecorator(new FileServiceImpl(), "src/test/resources");
    }
}
