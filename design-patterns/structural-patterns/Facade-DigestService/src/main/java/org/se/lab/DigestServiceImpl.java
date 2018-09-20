package org.se.lab;

import java.util.Arrays;

class DigestServiceImpl  // package private
    implements DigestService
{
    private final HexEncoder encoder;
    private final DigestAlgorithm digest;

    public DigestServiceImpl(DigestAlgorithm digest, HexEncoder encoder)
    {
        if(digest == null || encoder == null)
            throw new IllegalArgumentException("Invalid object references!");

        this.digest = digest;
        this.encoder = encoder;
    }

    public String toHashString(String data)
    {
        // Input validation
        if(data == null || data.trim().length() == 0)
            throw new IllegalArgumentException("Invalid data string: '" + data + "'");

        // Convert String data into bytes, calculate hash value, and convert into hex string
        byte[] bytes = encoder.toBytes(data);
        return toHashString(bytes);
    }

    public String toHashString(byte[] data)
    {
        // Input validation
        if(data == null || data.length == 0)
            throw new IllegalArgumentException("Invalid byte array: '" + Arrays.toString(data) + "'");

        // Calculate hash value, and convert into hex string
        byte[] hashValue = digest.hashBytes(data);
        return encoder.toHexString(hashValue);
    }
}
