package org.se.lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * This ConcreteHandler handles all requests that contain the words:
 * "Viagra" or "viagra" in their subject.
 */
public class SpamHandler
    extends MailHandler
{
    /*
     * Handler Operation
     */
	@Override
    public void handleRequest(Mail mail)
    {
        System.out.println("SpamHandler.handleRequest()");
        
        Pattern p = Pattern.compile("[Vv]iagra");
        Matcher m = p.matcher(mail.getSubject());

        if(m.find())
        {
            System.out.println(mail);
        }
        else
        {
            super.handleRequest(mail);
        }
    }
}
