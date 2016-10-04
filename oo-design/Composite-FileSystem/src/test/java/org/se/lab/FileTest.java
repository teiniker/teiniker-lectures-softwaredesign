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
		Assert.assertEquals(520, f.getSize());		
	}
	
	@Test
	public void testNumberOfFiles()
	{
		File f = new File("Node.java", 520);
		
		Assert.assertEquals(1, f.numberOfFiles());
	}
	
	@Test
	public void testSize()
	{
		File f = new File("Node.java", 1024);
		
		Assert.assertEquals(1024, f.getSize());
	}
	
	@Test(expected = NullPointerException.class)
	public void testNameNull()
	{
		new File(null, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSizeNegative()
	{
		new File("", -1);
	}

	@Test
	public void testEqualsAndHashCode()
	{
		File a = new File("README.txt", 666);
		File b = new File("README.txt", 666);
		File c = new File("README", 666);
		File d = new File("README.txt", 333);
		
		Assert.assertTrue(a.equals(b));
		Assert.assertTrue(b.equals(a));
		Assert.assertTrue(a.hashCode() == b.hashCode());
		
		Assert.assertFalse(a.equals(c));
		Assert.assertFalse(a.equals(d));
	}
	
	@Test
	public void testToString()
	{
		File f = new File("README.txt", 666);
		
		Assert.assertEquals("README.txt", f.toString());
	}
}
