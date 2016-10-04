package org.se.lab;

public class Mail
{
	/*
	 * Constructor
	 */
	public Mail(String address)
	{
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
			throw new IllegalArgumentException();
		this.address = address;
	}

	
	/*
	 * Association: ---[1]-> User
	 */
	private User owner;
	public User getOwner()
	{
		return owner;
	}	
	public void setOwner(User owner)
	{
		if(owner == null)
			throw new IllegalArgumentException();
		this.owner = owner;
	}
	
	
	
	/*
	 * Object methods
	 */
	

	@Override
	public String toString()
	{
		return "Mail [address=" + address + "]";
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
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
		Mail other = (Mail) obj;
		if (address == null)
		{
			if (other.address != null)
				return false;
		}
		else if (!address.equals(other.address))
			return false;
		return true;
	}
}