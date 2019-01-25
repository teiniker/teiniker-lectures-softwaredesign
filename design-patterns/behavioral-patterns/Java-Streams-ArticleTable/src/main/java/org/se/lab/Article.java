package org.se.lab;

public class Article
{
	/*
	 * Constructor
	 */
	public Article(long id, String description)
	{
		setId(id);
		setDescription(description);
	}
	
	
	/*
	 * Property: id <<identifier>>
	 */
	private long id;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		if(id < 0)
			throw new IllegalArgumentException("Invalid id!");
		this.id = id;
	}
	
	
	/*
	 * Property: description
	 */
	private String description;
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		if(description == null)
			throw new IllegalArgumentException("Invalid description!");
		this.description = description;
	}
	
	
	/*
	 * Object methods
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Article other = (Article) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Article [id=" + id + ", description=" + description + "]";
	}
}
