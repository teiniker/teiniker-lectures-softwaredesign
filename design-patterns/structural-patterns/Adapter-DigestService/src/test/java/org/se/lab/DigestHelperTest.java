package org.se.lab;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

public class DigestHelperTest
{
    private DigestHelper helper;
    
    @Before
    public void setup()
    {
        helper = new DigestHelper();
    }
    
    
    @Test
    public void testMD5() throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        String message = "mypassword"; 
        byte[] bytes = message.getBytes("UTF-8");
        byte[] hashValue = helper.toMD5(bytes);
        
        String hexString = Hex.encodeHexString(hashValue);   
        assertEquals(32, hexString.length());
        assertEquals("34819d7beeabb9260a5c854bc85b3e44", hexString);
        
        String base64String = Base64.encodeBase64String(hashValue);
        assertEquals(24, base64String.length()); 
        assertEquals("NIGde+6ruSYKXIVLyFs+RA==", base64String);
    }
}
