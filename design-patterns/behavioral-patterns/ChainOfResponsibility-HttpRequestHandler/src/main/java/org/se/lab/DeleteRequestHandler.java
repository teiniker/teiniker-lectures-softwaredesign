package org.se.lab;

class DeleteRequestHandler  // package private
	extends HttpRequestHandler
{

	@Override
	public String handleRequest(HttpRequest request)
	{
		String action = request.getParameters().get("action");		
		String id = request.getParameters().get("id");
		
		// TODO: Validate request parameter
		
		if(action.equals("Delete"))
		{
			String sql = new StringBuilder()
				.append("DELETE FROM user WHERE ID = ")
				.append(id)
				.toString();			
			return sql;
		}
		else
		{
			return super.handleRequest(request);
		}			
	}
}
