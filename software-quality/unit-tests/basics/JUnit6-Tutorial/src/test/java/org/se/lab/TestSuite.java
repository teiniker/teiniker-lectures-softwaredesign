package org.se.lab;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
    ExceptionTest.class,
    TimeoutTest.class
})
public class TestSuite
{
}
