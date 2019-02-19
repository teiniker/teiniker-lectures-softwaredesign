package org.se.lab;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.DefaultHandler;
import org.se.lab.FHJHandler;
import org.se.lab.MailHandler;
import org.se.lab.Mail;
import org.se.lab.SpamHandler;

public class MailHandlerTest
{
    private MailHandler handler;
    
    @Before
    public void setUp()
    {
    	SpamHandler spamHandler = new SpamHandler();
    	FHJHandler fhjHandler = new FHJHandler();
    	DefaultHandler defaultHandler = new DefaultHandler();
    	
    	handler = spamHandler;
    	spamHandler.setSuccessor(fhjHandler);
    	fhjHandler.setSuccessor(defaultHandler);    	
    	// :Test ---> :SpamHandler ---> :FHJHandler ---> :DefaultHandler 
    }

    
    @Test
    public void testFhjHandler()
    {
        Mail mail = new Mail();
        mail.setFrom("egon.teiniker@fh-joanneum.at");
        mail.setTo("office@kapfenberg.at");
        mail.setSubject("Verwaltungsstrafe");
        mail.setText("Ich bin sicher NICHT 180 km/h schnell gefahren!");
        
        handler.handleRequest(mail);
    }

    @Test
    public void testSpamHandler()
    {
        Mail mail = new Mail();
        mail.setFrom("xy@z.com");
        mail.setTo("egon.teiniker@fh-joanneum.at");
        mail.setSubject("Buy viagra now!");
        mail.setText("Our product has never been that cheap!");
        
        handler.handleRequest(mail);
    }

    @Test
    public void testDefaultHandler()
    {
        Mail mail = new Mail();
        mail.setFrom("egon.teiniker@gmx.at");
        mail.setTo("office@jboss.com");
        mail.setSubject("Bug report");
        mail.setText("The @EJB annotation does not work within servlet code!");
        
        handler.handleRequest(mail);
    }
}
