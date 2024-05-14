package org.se.lab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Blog
{
	/*
	 * Constructor
	 */
	public Blog(PostTable table)
	{
		if(table == null)
			throw new IllegalArgumentException();
		this.table = table;
	}
	
	/*
	 * Association: ---[1]-> PostTable
	 */
	private final PostTable table;
	
	
	public void post(String text)
	{
		try
		{
			Post p = new Post(IntegerSequence.nextValue(), text);
			table.insert(p);
		} 
		catch (SQLException e)
		{
			throw new BlogException(e);
		}
	}
	
	
	public List<Post> filter(String s)
	{
		if(s == null)
			throw new IllegalArgumentException();
		
		try
		{
			List<Post> result = new ArrayList<Post>();
			List<Post> posts;

			posts = table.findAll();
			for(Post p : posts)
			{
				if(p.getText().contains(s))
				{
					result.add(p);
				}
			}
			return result;
		} 
		catch (SQLException e)
		{
			throw new BlogException(e);
		}
	}
	
	public List<Post> getPosts()
	{
		List<Post> posts;
		try
		{
			posts = table.findAll();
			return Collections.unmodifiableList(posts);
		} 
		catch (SQLException e)
		{
			throw new BlogException(e);
		}
	}
}
