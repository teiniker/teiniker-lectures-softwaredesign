package org.se.lab;

public interface ServiceFactory
{
    ServiceFactory INSTANCE = new ServiceFactoryImpl(); // Singleton

    DigestService createDigestService();    // Factory Method
}
