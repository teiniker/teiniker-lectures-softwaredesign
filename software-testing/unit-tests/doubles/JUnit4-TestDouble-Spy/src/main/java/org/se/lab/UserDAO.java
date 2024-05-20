package org.se.lab;

public interface UserDAO
{
    void insert(User user);
    void update(User user);
    void delete(int id);
    
    User findById(int id);    
}
