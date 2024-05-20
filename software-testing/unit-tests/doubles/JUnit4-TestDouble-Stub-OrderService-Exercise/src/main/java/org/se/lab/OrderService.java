package org.se.lab;

import java.text.SimpleDateFormat;


public class OrderService
{
	/*
	 * Constructor
	 */
	public OrderService(OrderTable table)
	{
		if(table == null)
			throw new IllegalArgumentException("OrderTable is null!");
		
		this.table = table;
	}

	
	/*
	 * Dependency: table:OrderTable
	 */
	private OrderTable table;

    
    /*
     * Business Methods
     */

	public String toXml(int orderId)
	{
        try 
        {
        	StringBuilder xml = new StringBuilder();
        	Order order = table.findOrderById(orderId);

        	xml.append("<order id=\"").append(order.getId()).append("\" date=\"");	
        	SimpleDateFormat f = new SimpleDateFormat ("dd.MM.yyyy");
    		xml.append(f.format(order.getDate())).append("\" >\n");	
        	
    		for(OrderLine line : order.getLines())
    		{
    			xml.append("    <line id=\"").append(line.getId()).append("\" quantity=\"").append(line.getQuantity()).append("\" >\n");
    			xml.append("        <product id=\"").append(line.getProduct().getId());
    			xml.append("\" description=\"").append(line.getProduct().getDesc());
    			xml.append("\" price=\"").append(String.format("%5.2f", line.getProduct().getPrice()/100.0)).append("\" />\n");
    			xml.append("    </line>\n");
    		}
    		
        	xml.append("</order>");        	
            return xml.toString();
        }
        catch(TableException e)
        {
            throw new ServiceException(e.getMessage(), e);
        }
        catch(RuntimeException e)
        {
        	throw new ServiceException("Unknown problem!", e);
        }
	}
}
