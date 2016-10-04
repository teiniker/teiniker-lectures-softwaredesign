package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CompositeTest
{
	protected Node tree;
	
	@Before
	public void setup()
	{
		Node n3 = new Branch();
		n3.addNode(new GreenApple());
		n3.addNode(new RedApple());
		
		Node n1 = new Branch();
		n1.addNode(new Leaf());
		n1.addNode(n3);
		n1.addNode(new Leaf());
		
		Node n4 = new Branch();
		n4.addNode(new Leaf());
		n4.addNode(new RedApple());
		
		Node n2 = new Branch();
		n2.addNode(n4);
		n2.addNode(new GreenApple());
		n2.addNode(new Leaf());
		
		tree = new Branch();
		tree.addNode(n1);
		tree.addNode(n2);
	}

	@Test
	public void testComposite()
	{
		Assert.assertEquals(4, tree.numberOfLeafs());
		Assert.assertEquals(2, tree.numberOfGreenApples());
		Assert.assertEquals(2, tree.numberOfRedApples());
	}

}
