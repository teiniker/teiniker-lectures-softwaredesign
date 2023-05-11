package org.se.lab;

public class UserBuilder
{
    // default values
    private int id = 1;
    private String username = "user";
    private String password = "BPiZbadjt6lpsQKO4wB1aerzpjVIbdqyEdUSyFud+Ps=";

    // Builder operations

    public UserBuilder id(int id)
    {
        this.id = id;
        return this;
    }

    public UserBuilder username(String username)
    {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password)
    {
        this.password = password;
        return this;
    }

    public User build()
    {
        return new User(id, username, password);
    }

}
