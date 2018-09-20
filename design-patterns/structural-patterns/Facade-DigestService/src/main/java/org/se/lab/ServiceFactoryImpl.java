package org.se.lab;

class ServiceFactoryImpl
    implements ServiceFactory
{
    public DigestService createDigestService()
    {
        HexEncoder encoder = new HexEncoder();
        DigestAlgorithm digest = new DigestAlgorithm();
        return new DigestServiceImpl(digest, encoder);
    }
}
