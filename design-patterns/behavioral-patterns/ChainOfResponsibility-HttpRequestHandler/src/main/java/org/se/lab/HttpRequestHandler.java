package org.se.lab;

public abstract class HttpRequestHandler
{
    /*
     * Property: successor
     */
    private HttpRequestHandler successor;
    public HttpRequestHandler getSuccessor()
    {
        return successor;
    }
    public void setSuccessor(HttpRequestHandler successor)
    {
        this.successor = successor;
    }
    
    
    /*
     * Handler Operation (default implementation)
     */
    public String handleRequest(HttpRequest request)
    {
        if(getSuccessor() != null)
        {
            return getSuccessor().handleRequest(request);
        }
        else
        {
        	throw new IllegalStateException("No valid handler found!");
        }
        
    }
}
