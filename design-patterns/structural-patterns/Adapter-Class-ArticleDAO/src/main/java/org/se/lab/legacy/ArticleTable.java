package org.se.lab.legacy;

import java.sql.SQLException;

public class ArticleTable
{
	/*
	 * Simulate database access to provide a simple exam setting.
	 */
	private int id;
	private String description;
	private long price;

	
	public void save(int id, String description, long price) throws SQLException
	{
		this.id = id;
		this.description = description;
		this.price = price;
	}
	
		
	public void load(int id, StringHolder description, LongHolder price) throws SQLException
	{
		if(id != this.id)
			throw new SQLException("id not found!");
		description.value = this.description;
		price.value = this.price;
	}
}
