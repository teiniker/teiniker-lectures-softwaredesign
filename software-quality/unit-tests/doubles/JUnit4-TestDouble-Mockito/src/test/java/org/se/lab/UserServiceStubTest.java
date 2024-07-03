package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class UserServiceStubTest
{
    private UserDAO dao;            // DOC => Stub
    private UserService service;    // SUT

    @Before
    public void setup()
    {
        dao = Mockito.mock(UserDAO.class);
        //dao = Mockito.mock(UserDAOImpl.class);  // we can mock classes too...
        service = new UserService(dao);
    }

    @Test
    public void testUserToXml()
    {
        // setup
        User u = new User(7,"homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        when(dao.findById(7)).thenReturn(u);

        // exercise
        String xml = service.toXml(7);

        // verify
        String expected =
                "<user>" +
                "<id>7</id>" +
                "<name>homer</name>" +
                "<password>Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=</password>" +
                "</user>";
        Assert.assertEquals(expected, xml);
    }

    @Test
    public void testUserToXmlWithException()
    {
        // setup
        when(dao.findById(7)).thenThrow(new DAOException("Can't find user!"));

        // exercise
        try
        {
            service.toXml(7);
            Assert.fail();
        }
        catch(ServiceException e)
        {
            // verify
            Assert.assertEquals("Can't generate XML string!", e.getMessage());
            Assert.assertTrue(e.getCause() instanceof DAOException);
        }
    }

    @Test
    public void testAddUser()
    {
        // exercise
        service.addUser(new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8="));

        // verify
        verify(dao).insert(isA(User.class));
    }

    @Test
    public void testAddUserWithArgumentCaptor()
    {
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        // exercise
        service.addUser(new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8="));

        // verify
        verify(dao).insert(captor.capture());
        Assert.assertEquals(7, captor.getValue().getId());
        Assert.assertEquals("homer", captor.getValue().getUsername());
        Assert.assertEquals("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=", captor.getValue().getPassword());
    }

    @Test(expected = ServiceException.class)
    public void testAddUserWithException()
    {
        // setup
        doThrow(DAOException.class).when(dao).insert(isA(User.class));

        // exercise
        User user = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        service.addUser(user);
    }
}
