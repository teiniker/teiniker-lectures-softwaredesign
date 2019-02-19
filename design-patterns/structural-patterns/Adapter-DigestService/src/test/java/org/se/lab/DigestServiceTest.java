package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.apache.commons.codec.binary.Hex;
import org.junit.Before;
import org.junit.Test;

public class DigestServiceTest
{
    private DigestService service;
    
    @Before
    public void setup()
    {
        service = new DigestServiceImpl();
    }
    
    
    @Test
    public void testToBytes()
    {
        String message = "mypassword"; 
        byte[] bytes = service.toBytes(message);
        assertEquals(32, bytes.length); 
        assertEquals("89e01536ac207279409d4de1e5253e01f4a1769e696db0d6062ca9b8f56767c8", Hex.encodeHexString(bytes));
    }

    @Test
    public void testToHexString() 
    {
        String message = "mypassword"; 
        String hexString = service.toHexString(message);
        assertEquals(64, hexString.length()); 
        assertEquals("89e01536ac207279409d4de1e5253e01f4a1769e696db0d6062ca9b8f56767c8", hexString);
    }

    @Test
    public void testToBase64String()
    {
        String message = "mypassword"; 
        String base64String = service.toBase64String(message);
        assertEquals(44, base64String.length()); 
        assertEquals("ieAVNqwgcnlAnU3h5SU+AfShdp5pbbDWBiypuPVnZ8g=", base64String);
    }
}
