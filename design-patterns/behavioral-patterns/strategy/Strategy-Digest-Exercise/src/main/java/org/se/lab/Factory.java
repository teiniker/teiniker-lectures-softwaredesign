package org.se.lab;

public interface Factory
{
    Factory INSTANCE = new FactoryImpl();
    
    HashStrategy createHashAlgorithm(DigestType type);
}
