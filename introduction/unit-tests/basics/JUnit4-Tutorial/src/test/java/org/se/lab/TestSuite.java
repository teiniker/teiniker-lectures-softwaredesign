package org.se.lab;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    ExceptionTest.class, 
    TimeoutTest.class
})
public class TestSuite
{
}
