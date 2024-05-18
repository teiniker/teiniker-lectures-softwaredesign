package org.se.lab;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class HashTest
{
    @Test
    public void testSHA256() throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        String message = "password";

        byte[] bytes = message.getBytes("UTF-8");

        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        algorithm.update(bytes);
        byte[] hash = algorithm.digest();
        String hexString = convertToHexString(hash);

        assertEquals("5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8", hexString);
    }

    private String convertToHexString(byte[] bytes)
    {
        StringBuilder hex = new StringBuilder();
        for(byte b : bytes)
        {
            int i = (b & 0xff);
            hex.append(String.format("%02x", i));
        }
        return hex.toString();
    }
}
