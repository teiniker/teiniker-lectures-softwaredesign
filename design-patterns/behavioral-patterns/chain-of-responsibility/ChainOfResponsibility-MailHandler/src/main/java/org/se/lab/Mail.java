package org.se.lab;

public class Mail
{
    /*
     * Property: from
     */
    private String from;
    public String getFrom()
    {
        return from;
    }
    public void setFrom(String from)
    {
        this.from = from;
    }
    
    
    /*
     * Property: to
     */
    private String to;
    public String getTo()
    {
        return to;
    }
    public void setTo(String to)
    {
        this.to = to;
    }
    
    
    /*
     * Property: cc
     */
    private String cc;
    public String getCc()
    {
        return cc;
    }
    public void setCc(String cc)
    {
        this.cc = cc;
    }
    
    
    /*
     * Property: bcc
     */
    private String bcc;
    public String getBcc()
    {
        return bcc;
    }
    public void setBcc(String bcc)
    {
        this.bcc = bcc;
    }
    
    
    /*
     * Property: subject
     */
    private String subject;
    public String getSubject()
    {
        return subject;
    }
    public void setSubject(String subject)
    {
        this.subject = subject;
    }
    
    
    /*
     * Property: text
     */
    private String text;
    public String getText()
    {
        return text;
    }
    public void setText(String text)
    {
        this.text = text;
    }
    
    public String toString()
    {
        return "  from: " + getFrom() + "\n  to  : " + getTo() + "\n  subject: " + getSubject();
    }
}
