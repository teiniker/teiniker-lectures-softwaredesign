package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HttpRequestHandlerTest
{
	private HttpRequestHandler handler;
	
	@Before
	public void setup()
	{
		HttpRequestHandler addHandler = new AddRequestHandler();
		HttpRequestHandler deleteHandler = new DeleteRequestHandler();
		HttpRequestHandler unknownHandler = new UnknownActionRequestHandler();
		
		handler = addHandler;
		addHandler.setSuccessor(deleteHandler);
		deleteHandler.setSuccessor(unknownHandler);				
	}
	
	
	@Test
	public void testAdd()
	{
		HttpRequest request = new HttpRequest();
		request.getParameters().put("action", "Add");
		request.getParameters().put("firstName", "Homer");
		request.getParameters().put("lastName", "Simpson");
		request.getParameters().put("username", "homer");
		request.getParameters().put("password", "homer");
		
		final String SQL = "INSERT INTO user VALUES(NULL,'Homer','Simpson','homer','homer');";
		Assert.assertEquals(SQL, handler.handleRequest(request));
	}

	
	@Test
	public void testDelete()
	{
		HttpRequest request = new HttpRequest();
		request.getParameters().put("action", "Delete");
		request.getParameters().put("id", "7");
		
		final String SQL = "DELETE FROM user WHERE ID = 7;";
		Assert.assertEquals(SQL, handler.handleRequest(request));		
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testUnknownAction()
	{
		HttpRequest request = new HttpRequest();
		request.getParameters().put("action", "xxx");
		handler.handleRequest(request);
	}
}
