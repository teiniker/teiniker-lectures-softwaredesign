package org.se.lab;

/*
 * This ConcreteHandler handles all requests that contain the following
 * suffix in their mail address "@fh-joanneum.at".
 */
public class FHJHandler
    extends MailHandler
{
    /*
     * Handler Operation
     */
	@Override
    public void handleRequest(Mail mail)
    {
        System.out.println("FhjHandler.handleRequest()");
        
        if(mail.getFrom().endsWith("@fh-joanneum.at"))
        {
            System.out.println(mail);
        }
        else
        {
            super.handleRequest(mail);
        }            
    }
}
