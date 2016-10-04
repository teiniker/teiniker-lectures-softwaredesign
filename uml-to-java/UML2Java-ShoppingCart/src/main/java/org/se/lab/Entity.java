package org.se.lab;

public abstract class Entity
	implements XmlElement
{
	/*
	 * Constructor
	 */
	public Entity(int id)
	{
		setId(id);
	}
	
	
	/*
	 * Property: id:int
	 */
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}

	
	/*
	 * Object methods
	 */
	
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
		Entity other = (Entity) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

	@Override
	public String toString()
	{
		return toXml();
	}
}
