package org.se.lab;

import java.io.UnsupportedEncodingException;
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
            byte[] bytes = message.getBytes("UTF-8");
            MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
            algorithm.update(bytes);
            byte[] hashValue = algorithm.digest();
            return hashValue;
        }
        catch (UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            throw new ServiceException("Can't convert into SHA1 hex string!", e);
        }
    }

    public String toHexString(String message)
    {
        byte[] hashValue = toBytes(message);
        String hexString = Hex.encodeHexString(hashValue);
        return hexString;
    }

    public String toBase64String(String message)
    {
        byte[] hashValue = toBytes(message);
        String base64String = Base64.encodeBase64String(hashValue);
        return base64String;        
    }
}
