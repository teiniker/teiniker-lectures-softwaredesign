package org.se.lab;

public interface DigestService
{
    public String toHashString(String data);

    public String toHashString(byte[] data);
}
