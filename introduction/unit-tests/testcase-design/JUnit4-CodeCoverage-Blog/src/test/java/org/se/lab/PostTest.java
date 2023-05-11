package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostTest
{
	private Post post;
	
	@Before
	public void setup()
	{
		post = new Post(1, "Eve hacked FB!");
	}

	@Test
	public void testConstructor()
	{
		Assert.assertEquals(1, post.getId());
		Assert.assertEquals("Eve hacked FB!", post.getText());
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testSetIdNegativeId()
	{
		post.setId(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetTextNullPointer()
	{
		post.setText(null);
	}
	
	@Test
	public void testToString()
	{
		Assert.assertEquals("1,Eve hacked FB!", post.toString());
	}
	
	@Test
	public void testHashCode()
	{
		Post q = new Post(1, "Eve hacked FB!");
		
		Assert.assertTrue(post.hashCode() == q.hashCode());
	}
	
	@Test
	public void testEqualsThis()
	{
		Assert.assertTrue(post.equals(post));
	}
	
	@Test
	public void testEqualsNull()
	{
		Assert.assertFalse(post.equals(null));
	}
	
	@Test
	public void testEqualsWrongType()
	{
		Assert.assertFalse(post.equals(""));
	}
	
	@Test
	public void testEqualsWrongId()
	{
		Post q = new Post(2, "Eve hacked FB!");
		
		Assert.assertFalse(post.equals(q));
	}

	@Test
	public void testEquals()
	{
		Post q = new Post(1, "Eve hacked FB!");
		
		Assert.assertTrue(post.equals(q));
	}
}
