package org.se.lab;

public final class Book
{
	/*
	 * Constructor
	 */
	public Book(int id, String title, String author)
	{
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	
	/*
	 * Property: id:int
	 */
	private final int id;	
	public int getId()
	{
		return id;
	}

	
	/*
	 * Property: title:String
	 */
	private final String title;
	public String getAuthor()
	{
		return author;
	}


	/*
	 * Property: author:String
	 */
	private final String author;
	public String getTitle()
	{
		return title;
	}
	
	
	@Override
	public String toString()
	{
		return getId() + "," + getTitle() + "," + getAuthor();
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
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
