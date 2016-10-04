package org.se.lab;

public class EMail
{
    /*
     * Constructor
     */
    public EMail(String address)
    {
        setAddress(address);
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

    /*
     * Property: address:String
     */
    private String address;

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        if (address == null)
            throw new IllegalArgumentException("Invalid parameter address!");
        this.address = address;
    }

    
    
    /*
     * Object methods
     */
    
    @Override
    public String toString()
    {
        return getAddress();
    }
    
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
        EMail other = (EMail) obj;
        if (id != other.id)
            return false;
        return true;
    }
}