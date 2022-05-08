package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class HashStrategyFactoryTest
{    
    private static final String MESSAGE = "mypassword"; 
        
	@Test
	public void testSHA1() 
	{
		HashStrategy algorithm = Factory.INSTANCE.createHashAlgorithm(DigestType.SHA_1); 
		String hexString = algorithm.toHashString(MESSAGE);
		
		assertEquals(40, hexString.length()); 
		assertEquals("91dfd9ddb4198affc5c194cd8ce6d338fde470e2", hexString);
	}

	
	@Test
	public void testSHA256() 
	{
        HashStrategy algorithm = Factory.INSTANCE.createHashAlgorithm(DigestType.SHA_256); 
        String hexString = algorithm.toHashString(MESSAGE);

	    assertEquals(64, hexString.length()); 
		assertEquals("89e01536ac207279409d4de1e5253e01f4a1769e696db0d6062ca9b8f56767c8", hexString);
	}

	
	@Test
	public void testSHA512() 
	{
        HashStrategy algorithm = Factory.INSTANCE.createHashAlgorithm(DigestType.SHA_512); 
        String hexString = algorithm.toHashString(MESSAGE);
        
		assertEquals(128, hexString.length()); // 128 hex characters = 64 bytes
		assertEquals("a336f671080fbf4f2a230f313560ddf0d0c12dfcf1741e49e8722a234673037dc493caa8d291d8025f71089d63cea809cc8ae53e5b17054806837dbe4099c4ca", hexString);
	}
}
