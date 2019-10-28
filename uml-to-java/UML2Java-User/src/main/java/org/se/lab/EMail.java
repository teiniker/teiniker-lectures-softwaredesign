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
        if(address == null)
            throw new IllegalArgumentException("address is null!");

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
        if(user == null)
            throw new IllegalArgumentException("User is null!");

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
