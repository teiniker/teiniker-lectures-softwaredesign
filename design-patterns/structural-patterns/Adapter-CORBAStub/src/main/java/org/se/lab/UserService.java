package org.se.lab;

public interface UserService
{
	void addUser(User user);
	boolean loginUser(String username, String password);
}
