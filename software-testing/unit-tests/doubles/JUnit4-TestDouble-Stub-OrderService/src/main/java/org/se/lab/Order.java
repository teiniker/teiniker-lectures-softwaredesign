package org.se.lab;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order
	extends Entity
{
	/*
	 * Constructor
	 */
	public Order(int id, Date date)
	{
		setId(id);
		setDate(date);
	}
	
	
	/*
	 * Property: date:Date
	 */
	private Date date;
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	
	/*
	 * Association: ---[*]-> OrderLine
	 */
	private List<OrderLine> lines = new ArrayList<OrderLine>();
	public void addLine(OrderLine line)
	{
		if(line == null)
			throw new IllegalArgumentException();
		lines.add(line);
	}
	public List<OrderLine> getLines()
	{
		return lines;
	}
	
	
	/*
	 * Object methods
	 */
	@Override
	public String toString()
	{
		SimpleDateFormat f = new SimpleDateFormat ("dd.MM.yyyy");
		
		return getId() + "," + f.format(getDate()) + getLines();
	}
}
