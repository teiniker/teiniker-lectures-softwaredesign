package org.se.lab;

import org.junit.Assert;
import org.junit.Test;


public class FileTest
{
	@Test
	public void testCostructor()
	{
		File f = new File("File.java", 520);
		
		Assert.assertEquals("File.java", f.getName());
		Assert.assertEquals(520, f.numberOfBytes());
	}
	
	@Test
	public void testNumberOfFiles()
	{
		File f = new File("Node.java", 520);
		
		Assert.assertEquals(1, f.numberOfFiles());
	}
	
	@Test
	public void testNumberOfBytes()
	{
		File f = new File("Node.java", 1024);
		
		Assert.assertEquals(1024, f.numberOfBytes());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNameNull()
	{
		new File(null, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSizeNegative()
	{
		new File("", -1);
	}
}
