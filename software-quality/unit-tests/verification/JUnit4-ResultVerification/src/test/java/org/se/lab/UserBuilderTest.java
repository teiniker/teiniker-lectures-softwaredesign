package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class UserBuilderTest
{
    @Test
    public void testUserBuilder()
    {
        User user = new UserBuilder()
                .id(7)
                .username("homer")
                .password("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=")
                .build();

        Assert.assertEquals(7, user.getId());
        Assert.assertEquals("homer", user.getUsername());
        Assert.assertEquals("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=", user.getPassword());
    }


    @Test
    public void testUserBuilderWithDefaultValues()
    {
        // Builder with default values can reduce the setup code for objects significantly.
        User user = new UserBuilder().build();

        Assert.assertEquals(1, user.getId());
        Assert.assertEquals("user", user.getUsername());
        Assert.assertEquals("BPiZbadjt6lpsQKO4wB1aerzpjVIbdqyEdUSyFud+Ps=", user.getPassword());
    }
}
