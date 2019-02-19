package org.se.lab;

public interface LoginService
{
	void addUser(int id, String username, String password, String mail);

	boolean login(String username, String password);
	void logout();
}
