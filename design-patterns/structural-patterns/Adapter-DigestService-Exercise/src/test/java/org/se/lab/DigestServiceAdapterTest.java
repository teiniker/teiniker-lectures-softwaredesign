package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

public class DigestServiceAdapterTest
{
    private DigestService service;
    
    @Before
    public void setup()
    {
        service = new DigestServiceAdapter(new DigestHelper());
    }
    
    
    @Test
    public void testToBytes()
    {
        String message = "mypassword"; 
        byte[] bytes = service.toBytes(message);
        assertEquals(16, bytes.length); 
        assertEquals("34819d7beeabb9260a5c854bc85b3e44", Hex.encodeHexString(bytes));
    }

    @Test
    public void testToHexString() 
    {
        String message = "mypassword"; 
        String hexString = service.toHexString(message);
        assertEquals(32, hexString.length()); 
        assertEquals("34819d7beeabb9260a5c854bc85b3e44", hexString);
    }

    @Test
    public void testToBase64String()
    {
        String message = "mypassword"; 
        String base64String = service.toBase64String(message);
        assertEquals(24, base64String.length()); 
        assertEquals("NIGde+6ruSYKXIVLyFs+RA==", base64String);
    }
}
