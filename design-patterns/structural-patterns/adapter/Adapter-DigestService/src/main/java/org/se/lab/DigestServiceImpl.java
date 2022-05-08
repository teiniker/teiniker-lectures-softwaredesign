package org.se.lab;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class DigestServiceImpl implements DigestService
{
    public byte[] toBytes(String message)
    {
        try
        {
            byte[] bytes = message.getBytes(StandardCharsets.UTF_8);
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            algorithm.update(bytes);
            return algorithm.digest();
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new ServiceException("Can't convert into SHA1 hex string!", e);
        }
    }

    public String toHexString(String message)
    {
        byte[] hashValue = toBytes(message);
        return Hex.encodeHexString(hashValue);
    }

    public String toBase64String(String message)
    {
        byte[] hashValue = toBytes(message);
        return Base64.encodeBase64String(hashValue);
    }
}
