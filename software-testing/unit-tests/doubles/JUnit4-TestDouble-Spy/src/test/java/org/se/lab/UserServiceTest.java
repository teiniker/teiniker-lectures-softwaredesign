package org.se.lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserServiceTest
{
    private UserService service;
    private UserDAOSpy spy;

    @Before
    public void setup()
    {
        UserDAO dao = new UserDAOFake();
        spy = new UserDAOSpy(dao);
        service = new UserService(spy);

        service.addUser(new User(3,"marge", "tLgR+kBQUymuhx5S8DUnw3IMmvf7hgeBllhTXFSExB4="));
        service.addUser(new User(7,"homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8="));
    }


    @Test
    public void testUserToXml()
    {
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

        spy.logs.forEach(System.out::println);
        Assert.assertTrue(spy.logs.contains("insert:3,marge"));
        Assert.assertTrue(spy.logs.contains("insert:7,homer"));
        Assert.assertTrue(spy.logs.contains("findById:7=>7,homer"));
    }
}
