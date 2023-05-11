package org.se.lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest
{
    private UserService service;
    private UserDAOStub stub;

    @Before
    public void setup()
    {
        stub = new UserDAOStub();
        service = new UserService(stub);
    }

    @Test
    public void testAddUser()
    {
        // exercise
    	User user = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        service.addUser(user);      
        
        // verify
        assertEquals(user, stub.user);
    }


    @Test
    public void testAddUserWithException()
    {
        // setup
        stub.exception = new DAOException("Can't insert user!");

        // exercise
        User user = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        try
        {
            service.addUser(user);
            Assert.fail();
        }
        catch(ServiceException e)
        {
            // verify
            Assert.assertEquals("Can't insert user!", e.getMessage());
            Assert.assertTrue(e.getCause() instanceof DAOException);
        }
    }


    @Test
    public void testUserToXml()
    {
        // setup
    	stub.user = new User(7,"homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

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
        stub.exception = new DAOException("Can't find user!");

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


    private void assertEquals(User expected, User actual)
    {
        Assert.assertNotNull(expected);
        Assert.assertNotNull(actual);

        Assert.assertEquals(expected.getId(), actual.getId());
        Assert.assertEquals(expected.getUsername(), actual.getUsername());
        Assert.assertEquals(expected.getPassword(), actual.getPassword());
    }
}
