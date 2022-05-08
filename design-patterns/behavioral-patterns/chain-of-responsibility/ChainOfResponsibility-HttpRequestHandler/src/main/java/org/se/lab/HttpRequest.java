package org.se.lab;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest
{
	private Map<String, String> parameters = new HashMap<String,String>();
	public Map<String, String> getParameters()
	{
		return parameters;
	}
	public void setParameters(Map<String, String> parameters)
	{
		this.parameters = parameters;
	}
}
