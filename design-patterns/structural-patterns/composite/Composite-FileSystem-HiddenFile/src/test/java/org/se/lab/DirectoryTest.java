package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DirectoryTest
{
    private Node root;

	@Before
	public void setup()
	{
		root = new Directory("/");
		Node home = new Directory("home");
		root.addNode(home);

		Node teini = new Directory("teini");
		home.addNode(teini);
		teini.addNode(new HiddenFile(".bashrc", 1024));
		teini.addNode(new File("todo.txt", 2048));

		Node m2 = new HiddenDirectory(".m2");
		teini.addNode(m2);
		m2.addNode(new File("junit-4.10.jar", 253160));
        m2.addNode(new File("junit-4.10.pom", 2345));

		Node tomcat = new Directory("tomcat");
		home.addNode(tomcat);
		tomcat.addNode(new HiddenFile(".bashrc", 512));
	}


    /*
     *  /
     *  +- home/
     *       +- teini/
     *            +- .bashrc 	[1024 bytes]
     *            +- todo.txt 	[2048 bytes]
     *            +- .m2
     *                  +- junit-4.10.jar [253160 bytes]
     *                  +- junit-4.10.pom [2345 bytes]
     *       +- tomcat/
     *            +- .bashrc     [512 bytes]
     */
    @Test
    public void testNavigation()
    {
        Assert.assertEquals("/", root.getName());

        Directory home = (Directory)root.getNodes().get(0);
        Assert.assertEquals("home", home.getName());

        Directory teini = (Directory)home.getNodes().get(0);
        Assert.assertEquals("teini", teini.getName());
        Assert.assertEquals(".bashrc", teini.getNodes().get(0).getName());
        Assert.assertEquals(1024, teini.getNodes().get(0).numberOfBytes());
        Assert.assertEquals("todo.txt", teini.getNodes().get(1).getName());
        Assert.assertEquals(2048, teini.getNodes().get(1).numberOfBytes());

        HiddenDirectory m2 = (HiddenDirectory)teini.getNodes().get(2);
        Assert.assertEquals("junit-4.10.jar", m2.getNodes().get(0).getName());
        Assert.assertEquals(253160, m2.getNodes().get(0).numberOfBytes());
        Assert.assertEquals("junit-4.10.pom", m2.getNodes().get(1).getName());
        Assert.assertEquals(2345, m2.getNodes().get(1).numberOfBytes());

        Directory tomcat = (Directory)root.getNodes().get(0).getNodes().get(1);
        Assert.assertEquals("tomcat", tomcat.getName());
        Assert.assertEquals(".bashrc", tomcat.getNodes().get(0).getName());
        Assert.assertEquals(512, tomcat.getNodes().get(0).numberOfBytes());
    }

    @Test
    public void testNUmberOfBytes()
    {
        Assert.assertEquals(1024+2048+253160+2345+512, root.numberOfBytes());
    }

    @Test
    public void testNumberOfFiles()
    {
        Assert.assertEquals(5, root.numberOfFiles());
    }

    @Test(expected=IllegalArgumentException.class)
    public void testDIrectoryNameIsNull()
    {
        new Directory(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testAddNodeNull()
    {
        root.addNode(null);
    }
}
