package org.se.lab;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrderServiceTest
{
	private OrderTableStub stub;
	private OrderService service;
	
	
	@Before
	public void setup()
	{
		stub = new OrderTableStub();
		service = new OrderService(stub);		
	}

	@Test
	public void testToXml()
	{
		// setup
		GregorianCalendar date = new GregorianCalendar(2013,16,3);	
		Order order = new Order(1, date.getTime());		
		order.addLine(new OrderLine(11, 2, new Product(21, "Hardcore Java", 2870)));
		order.addLine(new OrderLine(12, 5, new Product(22, "The Java Programming Language", 4095)));
		stub.order = order;
				
		// exercise
		String xml = service.toXml(1);
		
		
		// verify 
		final String EXPECTED = 
			"<order id=\"1\" date=\"03.05.2014\" >\n" + 
			"    <line id=\"11\" quantity=\"2\" >\n" +
			"        <product id=\"21\" description=\"Hardcore Java\" price=\"28.70\" />\n" +
			"    </line>\n" +
			"    <line id=\"12\" quantity=\"5\" >\n" +
			"        <product id=\"22\" description=\"The Java Programming Language\" price=\"40.95\" />\n" +
			"    </line>\n" +
			"</order>";
		Assert.assertEquals(EXPECTED, xml);		
	}
	
	
	@Test
	public void testToXml_TableException()
	{
		// setup
		stub.exception = new TableException("Can't connect to database!");
		
		// exercise
		try
		{
			service.toXml(1);
			Assert.fail();
		}
		catch(ServiceException e)
		{
			// verify
			Assert.assertEquals("Can't connect to database!", e.getCause().getMessage());
		}
	}
	
	
	@Test
	public void testToXml_NullPointerException()
	{
		// setup
		stub.exception = new NullPointerException();
		
		// exercise
		try
		{
			service.toXml(1);
			Assert.fail();
		}
		catch(ServiceException e)
		{
			// verify
			Assert.assertTrue(e.getCause() instanceof NullPointerException);
		}
	}
}
