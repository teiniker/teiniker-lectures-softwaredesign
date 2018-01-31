package org.se.lab.test;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.DigestService;
import org.se.lab.ServiceFactory;


public class DigestServiceTest
{
    private DigestService service;
    
    @Before
    public void setup()
    {
        service = ServiceFactory.INSTANCE.createDigestService();
    }
    
    
    @Test
    public void testStringToHashString()
    {
        // Calculate hash value for a String
        String hex = service.toHashString("Drink4Bier!");
        Assert.assertEquals("ae7dffdf21c4ef4469b70a28b8387801c9ff8ae1fd5526bfc61e79d30fbecd25", hex);
    }

    @Test
    public void testBytesToHashString() throws DecoderException
    {
        byte[] bytes = Hex.decodeHex("ffeeddccbbaa99887766554433221100".toCharArray());

        // Calculate hash value for a byte array
        String hex = service.toHashString(bytes);
        Assert.assertEquals("811407f10d6c0f49a056cc8c01a15e42816b9d39df858e9f6c05fc5c9189b136", hex);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testToHashString_NullString()
    {
        service.toHashString((String)null);
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void testToHashString_EmptyString()
    {
        service.toHashString("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testToHashString_NullArray()
    {
        service.toHashString((byte[])null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testToHashString_EmptyArray()
    {
        service.toHashString(new byte[0]);
    }

}
