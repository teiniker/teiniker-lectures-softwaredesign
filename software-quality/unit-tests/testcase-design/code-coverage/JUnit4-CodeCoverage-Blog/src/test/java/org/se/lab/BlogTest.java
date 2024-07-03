package org.se.lab;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlogTest
{
	private Blog blog;
	private PostTableStub stub;
	
	@Before
	public void setup()
	{
		stub = new PostTableStub();
		blog = new Blog(stub);

		blog.post("First SWD Blog entry.");
		blog.post("In the 3rd semester SWD we learn cool things about software testing!!");
		blog.post("Also in the 3rd semester we hear about software design.");
	}
	
	@After
	public void teardown()
	{
		IntegerSequence.setValue(1); // reset sequence
	}
		
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructor_NullPointer()
	{
		new Blog(null);
	}
	
	@Test(expected=BlogException.class)
	public void testPost_SQLException()
	{
		stub.excpetion = new SQLException();
		blog.post("blah");
	}
	
	@Test
	public void testGetPosts()
	{
		List<Post> posts = blog.getPosts();	
		Assert.assertEquals(3, posts.size());
	}

	@Test(expected=BlogException.class)
	public void testGetPosts_SQLException()
	{
		stub.excpetion = new SQLException();
		blog.getPosts();
	}
	
	
	@Test
	public void testFilter()
	{
		List<Post> swdPosts = blog.filter("SWD");
		Assert.assertEquals(2, swdPosts.size());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFilterNullPointer()
	{
		blog.filter(null);
	}

	@Test(expected=BlogException.class)
	public void testFilterSQLException()
	{
		stub.excpetion = new SQLException();
		blog.filter("SWD");
	}
}
