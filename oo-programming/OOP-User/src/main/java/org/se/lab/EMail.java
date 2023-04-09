package org.se.lab;

public class EMail
    extends Entity
{
    /*
     * Constructor
     */
    public EMail(long id, String address)
    {
        setId(id);
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
        this.address = address;
    }


    /*
     * Association: ---[1]-> User
     */
    private User user;
    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }

    /*
     * Object methods
     */

    @Override
    public String toString()
    {
        return "EMail{" +
                "id=" + getId() +
                ", address='" + address + '\'' +
                '}';
    }
}
