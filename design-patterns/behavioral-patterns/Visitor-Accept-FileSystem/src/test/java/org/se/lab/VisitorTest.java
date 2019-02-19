package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VisitorTest
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
	@Before
	public void setup()
	{
		root = new Directory("/");
		Node home = new Directory("home");
		root.addNode(home);
		Node teini = new Directory("teini");
		home.addNode(teini);
		teini.addNode(new File(".bashrc", 1024));
		teini.addNode(new File("todo.txt", 2048));
		Node tomcat = new Directory("tomcat");
		home.addNode(tomcat);
		tomcat.addNode(new File(".bashrc", 512));		
	}
	
	@Test
	public void testGetSize()
	{
		FileSystemSizeVisitor visitor = new FileSystemSizeVisitor();
		root.accept(visitor);
		Assert.assertEquals(1024+2048+512, visitor.getSize());
	}
	
	@Test
	public void testNumberOfFiles()
	{
		FileSystemNumberOfFilesVisitor visitor = new FileSystemNumberOfFilesVisitor();
		root.accept(visitor);
		Assert.assertEquals(3, visitor.getNumberOfFiles());
	}
}
