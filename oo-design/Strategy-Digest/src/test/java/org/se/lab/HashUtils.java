package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;

public class HashUtils
{
    private HashUtils() {}
    
    public static byte[] toSHA1(String message)
        throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-1");
        algorithm.update(message.getBytes("UTF-8"));
        byte[] bytes = algorithm.digest();
        return bytes;
    }

    
    public static byte[] toSHA256(byte[] bytes)
        throws NoSuchAlgorithmException
    {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        algorithm.update(bytes);
        byte[] hash = algorithm.digest();
        return hash;
    }

    
    public static String toSHA512(String message)
        throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
        algorithm.update(message.getBytes("UTF-8"));
        byte[] hash = algorithm.digest();
        return Hex.encodeHexString(hash);
    }
}
