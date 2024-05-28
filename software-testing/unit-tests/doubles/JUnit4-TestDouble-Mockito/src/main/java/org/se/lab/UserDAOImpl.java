package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl
    implements UserDAO
{
    private List<User> table = new ArrayList<>();

    @Override
    public void insert(User user)
    {
        if(user == null)
            throw new IllegalStateException("User is null!");

        table.add(user);
    }

    @Override
    public void update(User user)
    {
       throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id)
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public User findById(int id)
    {
        for(User u : table)
        {
            if(u.getId() == id)
                return u;
        }
        return null;
    }
}
