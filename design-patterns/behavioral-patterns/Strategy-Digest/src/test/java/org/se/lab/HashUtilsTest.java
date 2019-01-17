package org.se.lab;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;


public class HashUtilsTest
{    
	@Test
	public void testCalculateSHA1() 
		throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String message = "mypassword"; 
		
		byte[] bytes = HashUtils.toSHA1(message);
		String hexString = Hex.encodeHexString(bytes);
		
		assertEquals(40, hexString.length()); 
		assertEquals("91dfd9ddb4198affc5c194cd8ce6d338fde470e2", hexString);
	}

	
	@Test
	public void testSHA256() 
		throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String message = "mypassword"; 
		
		byte[] bytes = HashUtils.toSHA256(message.getBytes("UTF-8"));

		String hexString = Hex.encodeHexString(bytes);
		assertEquals(64, hexString.length()); 
		assertEquals("89e01536ac207279409d4de1e5253e01f4a1769e696db0d6062ca9b8f56767c8", hexString);
	}

	
	@Test
	public void testSHA512() 
		throws NoSuchAlgorithmException, UnsupportedEncodingException
	{
		String message = "mypassword"; 
		
		String hexString = HashUtils.toSHA512(message);
		assertEquals(128, hexString.length()); // 128 hex characters = 64 bytes
		assertEquals("a336f671080fbf4f2a230f313560ddf0d0c12dfcf1741e49e8722a234673037dc493caa8d291d8025f71089d63cea809cc8ae53e5b17054806837dbe4099c4ca", hexString);
	}
}
