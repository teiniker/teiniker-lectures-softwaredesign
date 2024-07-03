package org.se.lab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostTableStub
	implements PostTable
{
	// Simulate DB table
	protected List<Post> posts = new ArrayList<Post>();
	
	// Simulate a SQL Exception
	// Note that for checked exceptions we have to handle the concrete
	protected SQLException excpetion;
	
	
	@Override
	public void insert(Post p) throws SQLException
	{
		if(excpetion != null)
			throw excpetion;
		
		posts.add(p);
	}

	@Override
	public Post findById(int id) throws SQLException
	{
		if(excpetion != null)
			throw excpetion;

		return posts.get(0);
	}

	@Override
	public List<Post> findAll() throws SQLException
	{
		if(excpetion != null)
			throw excpetion;

		return posts;
	}
}
