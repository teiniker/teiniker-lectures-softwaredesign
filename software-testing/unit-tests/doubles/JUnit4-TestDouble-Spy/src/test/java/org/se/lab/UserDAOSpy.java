package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class UserDAOSpy
    implements UserDAO
{
    private UserDAO dao;
    protected List<String> logs = new ArrayList<>();

    public UserDAOSpy(UserDAO dao)
    {
        this.dao = dao;
    }

    // Interface operations

    @Override
    public void insert(User user)
    {
        logs.add("insert:" + user);
        dao.insert(user);
    }

    @Override
    public void update(User user)
    {
        logs.add("update:" + user);
        dao.update(user);
    }

    @Override
    public void delete(int id)
    {
        logs.add("delete:" + id);
        dao.delete(id);
    }

    @Override
    public User findById(int id)
    {
        User user = dao.findById(id);
        logs.add("findById:" + id + "=>" + user);
        return user;
    }
}
