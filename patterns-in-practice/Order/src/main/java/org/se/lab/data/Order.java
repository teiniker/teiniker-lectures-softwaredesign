package org.se.lab.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order 
    extends Entity
{
    /*
     * Constructors
     */
    
    public Order(int id, Date date, ShippingType shippingtype)
	{
		setId(id);
		setDate(date);
		setShippingType(shippingtype);
	}
    
    public Order(Date date, ShippingType shippingtype)
    {
        this(IntegerSequence.nextValue(), date, shippingtype);
    }
	
	/*
	 * Property: date:Date
	 */
	private Date date;
	public Date getDate()
	{
		return this.date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	
	/*
	 * Property: shippingType:ShippingType
	 */

	private ShippingType shippingtype;
	public ShippingType getShippingType()
	{
		return shippingtype;
	}
	public void setShippingType(ShippingType shippingtype)
	{
		this.shippingtype = shippingtype;
	}
	
	
	/*
	 * Association: orderline:Orderline
	 */
	private List<OrderLine> orderlines = new ArrayList<OrderLine>();	
	public List<OrderLine> getOrderlines()
	{
		return orderlines;
	}
	public void addOrderline(OrderLine orderline)
	{
		this.orderlines.add(orderline);
	}
}
