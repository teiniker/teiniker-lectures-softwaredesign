package org.se.lab;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

class DigestServiceAdapter  // package private
    implements DigestService
{
    private DigestHelper helper; // adaptee
        
    public DigestServiceAdapter(DigestHelper helper)
    {
        if(helper == null)
            throw new IllegalArgumentException();
        this.helper = helper;
    }

    public byte[] toBytes(String message)
    {
        try
        {
            byte[] bytes = message.getBytes("UTF-8");
            byte[] hashValue = helper.toMD5(bytes); // delegate        
            return hashValue;
        }
        catch(UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            throw new ServiceException("Can't convert into MD5 hex string!", e);
        }
    }

    public String toHexString(String message)
    {
        try
        {
            byte[] bytes = message.getBytes("UTF-8");
            byte[] hashValue = helper.toMD5(bytes); // delegate
            String hexString = Hex.encodeHexString(hashValue);
            return hexString;
        }
        catch(UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            throw new ServiceException("Can't convert into MD5 hex string!", e);
        }
    }

    public String toBase64String(String message)
    {
        try
        {
            // convert parameter
            byte[] bytes = message.getBytes("UTF-8");
            // delegate
            byte[] hashValue = helper.toMD5(bytes);
            // convert result
            String base64String = Base64.encodeBase64String(hashValue);
            return base64String;
        }
        catch(UnsupportedEncodingException | NoSuchAlgorithmException e)
        {
            throw new ServiceException("Can't convert into MD5 hex string!", e);
        }
    }
}
