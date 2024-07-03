package org.se.lab;


/**
 * This is a dummy class that simulates UserDAO for unit tests.
 *
 */
public class UserDAOStub
	implements UserDAO
{
	/*
	 * Manage internal states
	 */

	protected int id;
	protected User user;
    protected RuntimeException exception;
	
	/*
	 * UserDAO methods
	 */
	public void delete(int id)
	{
		System.out.println("UserDAOStub> delete: " + id);
		this.id = id;
	}

	public User findById(int id)
	{
		System.out.println("UserDAOStub> findById: " + id);

		if(exception != null)
			throw exception;

		return user;
	}

	public void insert(User user)
	{
		System.out.println("UserDAOStub> insert: " + user);

        if(exception != null)
            throw exception;

		this.user=user;
	}

	public void update(User user)
	{
		System.out.println("UserDAOStub> update: " + user);

        if(exception != null)
            throw exception;

		this.user=user;
	}
}
