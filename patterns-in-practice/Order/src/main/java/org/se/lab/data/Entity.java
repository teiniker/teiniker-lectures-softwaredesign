package org.se.lab.data;

public abstract class Entity 
{	
	/*
	 * Property: id:int
	 */
    private int id;
	public int getId()
	{
		return this.id;
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
}
