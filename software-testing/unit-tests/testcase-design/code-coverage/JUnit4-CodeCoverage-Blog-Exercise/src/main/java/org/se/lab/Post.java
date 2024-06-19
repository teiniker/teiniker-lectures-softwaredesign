package org.se.lab;

public class Post
{
	/*
	 * Constructor
	 */
	public Post(int id, String text)
	{
		setId(id);
		setText(text);
	}
	

	/*
	 * Property: id
	 */
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		if(id < 0)
			throw new IllegalArgumentException();
		this.id = id;
	}
	
	
	/*
	 * Property: text
	 */
	private String text;
	public String getText()
	{
		return text;
	}
	public void setText(String text)
	{
		if(text == null)
			throw new IllegalArgumentException();
		this.text = text;
	}
	
	
	/*
	 * Object methods
	 */	
	
	@Override
	public String toString()
	{
		return getId() + "," + getText();
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
