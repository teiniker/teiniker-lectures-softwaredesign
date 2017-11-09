package org.se.lab;

public abstract class Entity
        implements Comparable<Entity>
{
    /*
     * Constructor
     */
    public Entity(long id)
    {
        setId(id);
    }

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
        this.id = id;
    }

    @Override
    public int compareTo(Entity u)
    {
        if(id == u.id)
            return 0;
        else if(id < u.id)
            return -1;
        else
            return 1;
    }

}
