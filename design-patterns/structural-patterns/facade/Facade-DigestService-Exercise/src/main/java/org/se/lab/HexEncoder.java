package org.se.lab;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

public class HexEncoder
{
    public String toHexString(byte[] bytes)
    {
        return Hex.encodeHexString(bytes);
    }

    public byte[] toBytes(String data)
    {
        try
        {
            return data.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            throw new IllegalStateException("Can't convert stringc '" + data + "' into bytes!", e);
        }
    }
}
