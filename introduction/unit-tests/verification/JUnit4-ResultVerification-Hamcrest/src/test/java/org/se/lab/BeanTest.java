package org.se.lab;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

public class BeanTest
{
    private User user;

    @Before
    public void setup()
    {
        user = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
    }

    @Test
    public void testEqualTo()
    {
        assertThat(7, equalTo(user.getId()));
        assertThat("Homer", equalToIgnoringCase(user.getUsername()));
        assertThat("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=", equalTo(user.getPassword()));
    }

    @Test
    public void testToString()
    {
        assertThat(user, hasToString("7,homer"));
    }


    @Test
    public void testProperties()
    {
        assertThat(user, hasProperty("username", equalTo("homer")));
        assertThat(user, hasProperty("password", equalTo("Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=")));
    }

    @Test
    public void testAllProperties()
    {
        User expected = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

        assertThat(expected, samePropertyValuesAs(user));
    }

    @Test
    public void testType()
    {
        assertThat(user, instanceOf(User.class));
    }

    @Test
    public void testSameInstance()
    {
        User other = user;

        assertThat(other, sameInstance(user));
    }

}
