package org.se.lab;

class AddRequestHandler // package private
	extends HttpRequestHandler
{

	@Override
	public String handleRequest(HttpRequest request)
	{
		String action = request.getParameters().get("action");
		String firstName = request.getParameters().get("firstName");
		String lastName = request.getParameters().get("lastName");
		String username = request.getParameters().get("username");
		String password = request.getParameters().get("password");
		
		// TODO: Validate request parameters
		// TODO: salt + hash password
		
		if(action.equals("Add"))
		{
			String sql = new StringBuilder()
				.append("INSERT INTO user VALUES (NULL,'")
				.append(firstName).append("','")
				.append(lastName).append("','")
				.append(username).append("','")
				.append(password).append("')")
				.toString();
		
			// TODO: Use a prepared statement to prevent SQL injection attacks
			return sql;
		}
		else
		{
			return super.handleRequest(request);
		}			
	}
}
