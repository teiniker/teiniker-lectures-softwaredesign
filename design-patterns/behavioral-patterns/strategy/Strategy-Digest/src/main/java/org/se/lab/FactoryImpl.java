package org.se.lab;

class FactoryImpl // package-private
    implements Factory
{
    @Override
    public HashStrategy createHashAlgorithm(DigestType type)
    {
        switch(type)
        {
            case SHA_1: return new HashStrategySHA1(); 
            case SHA_256: return new HashStrategySHA256(); 
            case SHA_512: return new HashStrategySHA512(); 
            default:
                throw new IllegalArgumentException();
        }
    }
}
