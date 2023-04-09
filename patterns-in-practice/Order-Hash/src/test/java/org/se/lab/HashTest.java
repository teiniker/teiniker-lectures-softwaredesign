package org.se.lab;

import org.junit.Test;

import java.util.Objects;

public class HashTest
{
    public int hashCode1(int id)
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    public int hashCode2(long id)
    {
        return (int) (id ^ (id >>> 32));
    }

    @Test
    public void testHashCode()
    {
        for(int i=-1000; i<1000; i++)
            System.out.printf("%d: %d %d\n", i, hashCode1(i), hashCode2(i));
    }


}
