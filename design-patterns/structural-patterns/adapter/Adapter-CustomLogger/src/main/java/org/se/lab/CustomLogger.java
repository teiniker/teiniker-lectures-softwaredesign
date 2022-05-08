package org.se.lab;

/*
 * Target Interface
 *  
 * This interface defines the domain-specific interface that a client can use.
 */
public interface CustomLogger
{
    void error(String message);
    void warning(String message);
    void info(String message);
    void debug(String message);
}
