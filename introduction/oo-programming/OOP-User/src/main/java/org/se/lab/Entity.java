package org.se.lab;

public abstract class Entity
{
    /*
     * Property: id:long
     */
    private long id;
    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        // input validation
        if(id < 0)
            throw new IllegalArgumentException("Invalid id: " + id);

        this.id = id;
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return id == entity.id;
    }

    @Override
    public int hashCode()
    {
        return (int) (id ^ (id >>> 32));
    }
}
