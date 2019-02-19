package org.se.lab;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.Connection;
import org.se.lab.ConnectionImpl;
import org.se.lab.ConnectionPSM;

public class ConnectionTest
{
	private Connection connection;
	private ConnectionImpl impl;
	
	@Before
	public void setUp()
	{
		impl = new ConnectionImpl();
		connection = new ConnectionPSM(impl);
	}
	
	@Test
	public void testConnection()
	{
		connection.open();
		connection.send("Hallo");
		connection.receive();
		connection.close();
		
		assertEquals("[open(), send(\"Hallo\"), receive(), close()]",
				impl.getOutput().toString());
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void testWitoutOpen()
	{
		connection.send("Hallo");
		connection.receive();		
	}

	
	@Test(expected = IllegalStateException.class)
	public void testReOpen()
	{
		connection.open();
		connection.open();
	}
}
