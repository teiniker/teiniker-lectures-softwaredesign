package org.se.lab;

import java.sql.SQLException;
import java.util.List;

public interface PostTable
{
	void insert(Post p) throws SQLException;
	
	Post findById(int id) throws SQLException;
	List<Post> findAll() throws SQLException;
}
