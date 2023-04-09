package org.se.lab;

import java.util.Objects;

public class Password
{
    public Password(String password)
    {
        setPassword(password);
    }

    private String password;
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public String toString()
    {
        return password ;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return Objects.equals(password, password1.password);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(password);
    }
}
