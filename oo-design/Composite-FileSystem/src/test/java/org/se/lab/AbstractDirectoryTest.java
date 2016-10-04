package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractDirectoryTest
{
	protected Node root;
		
	/*
	 *  /
	 *  +- home/
	 *       +- teini/
	 *            +- .bashrc 	[1024 bytes]
	 *            +- todo.txt 	[2048 bytes]
	 *       +- tomcat/
	 *            +- .bashrc     [512 bytes] 
	 */
	@Test
	public void testNavigation()
	{
		Assert.assertEquals("/", root.getName());
		Assert.assertEquals("home", root.getNodes().get(0).getName());
		Assert.assertEquals("teini", root.getNodes().get(0).getNodes().get(0).getName());
		Assert.assertEquals(".bashrc", root.getNodes().get(0).getNodes().get(0).getNodes().get(0).getName());
		Assert.assertEquals(1024, root.getNodes().get(0).getNodes().get(0).getNodes().get(0).getSize());
		Assert.assertEquals("todo.txt", root.getNodes().get(0).getNodes().get(0).getNodes().get(1).getName());
		Assert.assertEquals(2048, root.getNodes().get(0).getNodes().get(0).getNodes().get(1).getSize());
		
		Assert.assertEquals("tomcat", root.getNodes().get(0).getNodes().get(1).getName());
		Assert.assertEquals(".bashrc", root.getNodes().get(0).getNodes().get(1).getNodes().get(0).getName());
		Assert.assertEquals(512, root.getNodes().get(0).getNodes().get(1).getNodes().get(0).getSize());		
	}
	
	@Test
	public void testGetSize()
	{
		Assert.assertEquals(1024+2048+512, root.getSize());
	}
	
	@Test
	public void testNumberOfFiles()
	{
		Assert.assertEquals(3, root.numberOfFiles());
	}
	
	@Test(expected=NullPointerException.class)
	public void testSetNameNull()
	{
		new Directory(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testAddNodeNull()
	{
		root.addNode(null);
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testReadOnlyList()
	{
		root.getNodes().add(new File("virus", 666));
	}
}
