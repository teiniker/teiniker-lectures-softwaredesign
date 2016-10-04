package org.se.lab;

import org.junit.Before;

public class DirectoryTest
	extends AbstractDirectoryTest
{
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
}
