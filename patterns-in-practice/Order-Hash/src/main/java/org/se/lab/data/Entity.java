package org.se.lab.data;

import java.util.Objects;

public abstract class Entity
{	
	/*
	 * Property: id:int
	 */
    private long id;
	public long getId()
	{
		return this.id;
	}
	public void setId(long id)
	{
		this.id = id;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
