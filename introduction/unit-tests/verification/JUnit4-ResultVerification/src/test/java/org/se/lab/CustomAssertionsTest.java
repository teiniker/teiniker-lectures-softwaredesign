package org.se.lab;

import org.junit.Test;


public class CustomAssertionsTest
{
    @Test
    public void testEachAttribute()
    {
        User u = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");

        // verify
        User expected = new User(7, "homer", "Kqq3lbODaQT4LvxsoihdknrtdSBiFOHaODQY65DJBS8=");
        CustomAssert.assertEquals(expected, u);
    }
}
