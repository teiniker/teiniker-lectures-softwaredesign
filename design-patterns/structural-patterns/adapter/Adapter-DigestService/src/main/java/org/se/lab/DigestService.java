package org.se.lab;

/*
 * Note that every convert method can throw a ServiceException in case of a problem!!
 */

public interface DigestService
{
    byte[] toBytes(String message);
    String toHexString(String message);    
    String toBase64String(String message);
}
