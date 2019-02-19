package org.se.lab;

/*
 * This ConcreteHandler handles all requests that are not handled
 * by other Handler objects.
 * Usually, this handler marks the end of a chain.
 */
public class DefaultHandler
    extends MailHandler
{
    /*
     * Handler Operation
     */
	@Override
    public void handleRequest(Mail mail)
    {
        System.out.println("DefaultHandler.handleRequest()");
        System.out.println(mail);
    }
}
