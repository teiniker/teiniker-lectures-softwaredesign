package org.se.lab;

public class EMail
    extends Entity
{
    /*
     * Constructor
     */
    public EMail(long id, String address)
    {
        super(id);
        setAddress(address);
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
        return getId() + ", " + getAddress();
    }
    
}