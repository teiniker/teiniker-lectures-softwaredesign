package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DigestHelper
{
    public byte[] toMD5(byte[] bytes) 
            throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        algorithm.update(bytes);
        return algorithm.digest();
    }
}
