package org.se.lab;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter
	extends Formatter
{
    public synchronized String format(LogRecord record) 
    {
        StringBuffer b = new StringBuffer();
        b.append(new Date());
        b.append(" ");
        b.append(record.getMessage());
        b.append(System.getProperty("line.separator"));
        return b.toString(); 
    }
}
