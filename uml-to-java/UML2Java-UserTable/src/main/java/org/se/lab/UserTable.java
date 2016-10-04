package org.se.lab;

import java.util.List;


public interface UserTable
{
	void insertUser(User u);
	
	User findById(int id);
	List<User> findAll();
}
