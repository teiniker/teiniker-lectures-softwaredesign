package org.se.lab;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class DigestAlgorithm    // package private
{
    public byte[] hashBytes(byte[] bytes)
    {
        MessageDigest algorithm;
        try
        {
            algorithm = MessageDigest.getInstance("SHA-256");
            algorithm.update(bytes);
            byte[] hash = algorithm.digest();
            return hash;
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new IllegalStateException("Can't calculate hash value!", e);
        }       
    }
}
